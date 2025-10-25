package com.swd.e_bake_ingredients.dto.order;

import com.swd.e_bake_ingredients.constant.PaymentStatusValue;
import com.swd.e_bake_ingredients.constant.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Integer id;
    private PaymentMethod method;
    private Double amount;
    private PaymentStatusValue currentStatus;
    private List<PaymentStatusDTO> statusHistory;
    private LocalDateTime createdAt;
}