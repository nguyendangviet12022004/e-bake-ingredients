package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.order.*;
import com.swd.e_bake_ingredients.entity.order.Order;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDTO toDTO(Order e) {
        if (e == null)
            return null;

        List<ItemDTO> items = Collections.emptyList();
        if (e.getItems() != null) {
            items = e.getItems().stream().map(ItemMapper::toDTO).collect(Collectors.toList());
        }

        List<OrderStatusDTO> statusHistory = Collections.emptyList();
        if (e.getStatusHistory() != null) {
            statusHistory = e.getStatusHistory().stream().map(OrderStatusMapper::toDTO).collect(Collectors.toList());
        }

        double total = 0.0;

        for (ItemDTO item : items) {
            total += item.getSubtotal();
        }

        return OrderDTO.builder()
                .id(e.getId())
                .customerId(e.getCustomer() != null ? e.getCustomer().getId() : null)
                .items(items)
                .delivery(DeliveryMapper.toDTO(e.getDelivery()))
                .payment(PaymentMapper.toDTO(e.getPayment()))
                .currentStatus(OrderStatusMapper.toDTO(e.getCurrentStatus()))
                .statusHistory(statusHistory)
                .currentStatusValue(e.getCurrentStatus().getStatus())
                .total(total)
                .createdAt(e.getCreatedAt())
                .updatedAt(e.getUpdatedAt())
                .build();
    }
}