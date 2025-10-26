package com.swd.e_bake_ingredients.service.impl;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swd.e_bake_ingredients.config.security.AccountUserDetails;
import com.swd.e_bake_ingredients.dto.order.AddressDTO;
import com.swd.e_bake_ingredients.dto.order.DeliveryDTO;
import com.swd.e_bake_ingredients.dto.order.ItemDTO;
import com.swd.e_bake_ingredients.dto.order.OrderCreateDTO;
import com.swd.e_bake_ingredients.dto.order.OrderDTO;
import com.swd.e_bake_ingredients.dto.order.OrderStatusDTO;
import com.swd.e_bake_ingredients.dto.order.PaymentDTO;
import com.swd.e_bake_ingredients.entity.auth.Customer;
import com.swd.e_bake_ingredients.entity.order.Address;
import com.swd.e_bake_ingredients.entity.order.Cart;
import com.swd.e_bake_ingredients.entity.order.Delivery;
import com.swd.e_bake_ingredients.entity.order.Item;
import com.swd.e_bake_ingredients.entity.order.Order;
import com.swd.e_bake_ingredients.entity.order.Payment;
import com.swd.e_bake_ingredients.entity.tracking.OrderStatus;
import com.swd.e_bake_ingredients.entity.tracking.PaymentStatus;
import com.swd.e_bake_ingredients.constant.OrderStatusValue;
import com.swd.e_bake_ingredients.constant.PaymentMethod;
import com.swd.e_bake_ingredients.constant.PaymentStatusValue;
import com.swd.e_bake_ingredients.mapper.OrderMapper;
import com.swd.e_bake_ingredients.repository.AddressRepository;
import com.swd.e_bake_ingredients.repository.CartRepository;
import com.swd.e_bake_ingredients.repository.OrderRepository;
import com.swd.e_bake_ingredients.service.AddressService;
import com.swd.e_bake_ingredients.service.CartService;
import com.swd.e_bake_ingredients.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CartService cartService;
    private final CartRepository cartRepository;
    private final AddressRepository addressRepository;
    private final OrderRepository orderRepository;
    private final AddressService addressService;

    private Integer resolveAccountId(Authentication authentication) {
        return ((AccountUserDetails) authentication.getPrincipal()).getAccount().getId();
    }

    @Override
    public OrderDTO prepareOrderForCreation(List<Integer> selectedItemIds, Authentication authentication) {
        // get cart DTO
        var cart = cartService.getCart(authentication);
        List<ItemDTO> items;
        if (selectedItemIds == null || selectedItemIds.isEmpty()) {
            items = cart.getItems();
        } else {
            Set<Integer> set = new HashSet<>(selectedItemIds);
            items = cart.getItems().stream()
                    .filter(i -> i.getId() != null && set.contains(i.getId()))
                    .collect(Collectors.toList());
        }

        double total = items.stream()
                .filter(i -> i.getSubtotal() != null)
                .mapToDouble(i -> i.getSubtotal())
                .sum();

        // choose default address if present
        List<AddressDTO> addrs = addressService.getCurrentAddresses(authentication);
        AddressDTO defaultAddr = (addrs != null && !addrs.isEmpty()) ? addrs.get(0) : null;

        OrderDTO draft = new OrderDTO();
        draft.setItems(items);
        draft.setTotal(total);
        draft.setDelivery(DeliveryDTO.builder().address(defaultAddr).build());

        draft.setPayment(PaymentDTO.builder().method(PaymentMethod.CASH).build());
        draft.setCurrentStatus(OrderStatusDTO.builder().status(OrderStatusValue.DRAFT).build());
        draft.setCreatedAt(LocalDateTime.now());
        return draft;
    }

    @Override
    @Transactional
    public OrderDTO createOrder(OrderCreateDTO dto, Authentication authentication) {
        Integer accountId = resolveAccountId(authentication);

        Cart cart = this.cartRepository.findByCustomerId(accountId).get();
        if (cart == null || cart.getItems() == null || cart.getItems().isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        // collect selected items from cart entity
        Set<Integer> selected = dto.getSelectedItemIds() == null ? Collections.emptySet()
                : new HashSet<>(dto.getSelectedItemIds());

        List<Item> itemsToOrder;
        if (selected.isEmpty()) {
            itemsToOrder = new ArrayList<>(cart.getItems());
        } else {
            itemsToOrder = cart.getItems().stream()
                    .filter(i -> i.getId() != null && selected.contains(i.getId()))
                    .collect(Collectors.toList());
        }

        if (itemsToOrder.isEmpty()) {
            throw new IllegalArgumentException("No items selected for order");
        }

        Order order = new Order();
        order.setCustomer(Customer.builder().id(accountId).build());
        order.setItems(itemsToOrder);
        double total = 0.0;
        for (Item it : itemsToOrder) {
            // detach from cart
            it.setCart(null);
            it.setOrder(order);
            double up = it.getUnitPrice() != null ? it.getUnitPrice() : 0.0;
            int q = it.getQuantity() != null ? it.getQuantity() : 0;
            total += up * q;
        }

        // delivery: attach address if provided
        if (dto.getAddressId() != null) {
            Address address = addressRepository.findById(dto.getAddressId()).orElse(null);
            if (address != null) {
                var delivery = new Delivery();
                delivery.setAddress(address);
                order.setDelivery(delivery);
            }
        }

        // payment: create a payment entity with method and amount
        Payment payment = new Payment();
        payment.setMethod(dto.getPaymentMethod() == null ? null : dto.getPaymentMethod());
        payment.setAmount(total);
        order.setPayment(payment);

        // create initial order status and add to history
        OrderStatus initStatus = new OrderStatus();
        initStatus.setDescription("Order created");
        initStatus.setStatus(OrderStatusValue.PROCESSING);
        initStatus.setOrder(order);
        order.setCurrentStatus(initStatus);
        order.setStatusHistory(List.of(initStatus));

        // create initial payemnt status and add to history
        PaymentStatus paymentStatus = new PaymentStatus();
        paymentStatus.setDescription("Processing");
        paymentStatus.setStatus(PaymentStatusValue.PENDING);
        paymentStatus.setPayment(payment);
        payment.setCurrentStatus(paymentStatus);
        payment.setStatusHistory(List.of(paymentStatus));

        // persist order
        Order saved = orderRepository.save(order);

        // // todo remove item
        // // remove ordered items from cart entity and recalc cart total
        // cart.getItems().removeAll(itemsToOrder);

        // cartRepository.save(cart);

        // return DTO of saved order
        return OrderMapper.toDTO(saved);
    }
}