package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.order.PaymentStatusDTO;
import com.swd.e_bake_ingredients.entity.tracking.PaymentStatus;

public class PaymentStatusMapper {
    public static PaymentStatusDTO toDTO(PaymentStatus e) {
        if (e == null) return null;
        return PaymentStatusDTO.builder()
                .id(e.getId())
                .description(e.getDescription())
                .timestamp(e.getTimestamp())
                .status(e.getStatus())
                .build();
    }
}