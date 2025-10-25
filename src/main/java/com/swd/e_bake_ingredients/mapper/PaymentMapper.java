package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.order.PaymentDTO;
import com.swd.e_bake_ingredients.entity.order.Payment;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentMapper {

    public static PaymentDTO toDTO(Payment e) {
        if (e == null)
            return null;
        List<com.swd.e_bake_ingredients.dto.order.PaymentStatusDTO> history = Collections.emptyList();
        if (e.getStatusHistory() != null) {
            history = e.getStatusHistory().stream()
                    .map(PaymentStatusMapper::toDTO)
                    .collect(Collectors.toList());
        }
        return PaymentDTO.builder()
                .id(e.getId())
                .method(e.getMethod())
                .amount(e.getAmount())
                .currentStatus(e.getCurrentStatus().getStatus())
                .statusHistory(history)
                .createdAt(e.getCreatedAt())
                .build();
    }
}