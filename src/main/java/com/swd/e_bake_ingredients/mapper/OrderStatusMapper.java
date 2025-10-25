package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.order.OrderStatusDTO;
import com.swd.e_bake_ingredients.entity.tracking.OrderStatus;

public class OrderStatusMapper {
    public static OrderStatusDTO toDTO(OrderStatus e) {
        if (e == null) return null;
        return OrderStatusDTO.builder()
                .id(e.getId())
                .description(e.getDescription())
                .timestamp(e.getTimestamp())
                .status(e.getStatus())
                .build();
    }
}