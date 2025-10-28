package com.swd.e_bake_ingredients.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.swd.e_bake_ingredients.dto.order.AddressDTO;
import com.swd.e_bake_ingredients.dto.order.OrderCreateDTO;
import com.swd.e_bake_ingredients.dto.order.OrderDTO;
import com.swd.e_bake_ingredients.dto.order.OrderSummaryDTO;
import com.swd.e_bake_ingredients.service.AddressService;
import com.swd.e_bake_ingredients.service.OrderService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import com.swd.e_bake_ingredients.constant.PaymentMethod;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final AddressService addressService;
    private final OrderService orderService;

    // show create page. selectedItemIds come from cart checkbox submit
    @GetMapping("/create")
    public String createOrderPage(@RequestParam(required = true) Integer[] selectedItemIds,
            Model model,
            Authentication authentication) {
        List<Integer> selected = selectedItemIds == null ? null : Arrays.asList(selectedItemIds);
        OrderDTO draft = orderService.prepareOrderForCreation(selected, authentication);

        List<AddressDTO> addresses = addressService.getCurrentAddresses(authentication);

        model.addAttribute("draft", draft);
        model.addAttribute("addresses", addresses);
        model.addAttribute("paymentMethods", PaymentMethod.values());
        OrderCreateDTO createDto = new OrderCreateDTO();
        createDto.setSelectedItemIds(selected);
        if (!addresses.isEmpty())
            createDto.setAddressId(addresses.get(0).getId());
        model.addAttribute("createDto", createDto);
        return "order/create";
    }

    @PostMapping("/create")
    public String createOrder(@ModelAttribute("createDto") OrderCreateDTO createDto,
            Authentication authentication,
            Model model) {
        OrderDTO order = orderService.createOrder(createDto, authentication);
        model.addAttribute("order", order);
        // simple success page; you may redirect to order details page instead
        return "order/detail";
    }

    @GetMapping("/list/customer")
    public String listCustomerOrders(Authentication authentication, Model model) {
        List<OrderSummaryDTO> orders = orderService.getOrdersForCurrentCustomer(authentication);
        model.addAttribute("orders", orders);
        return "order/list/customer";
    }

}