package com.swd.e_bake_ingredients.dto.order;

import com.swd.e_bake_ingredients.constant.PaymentStatusValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentStatusDTO {
    private Integer id;
    private String description;
    private LocalDateTime timestamp;
    private PaymentStatusValue status;
}