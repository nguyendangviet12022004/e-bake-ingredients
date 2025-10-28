package com.swd.e_bake_ingredients.dto.order;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSummaryDTO {
    private Integer id;
    private LocalDateTime createdAt;
    private String status;
    private Double total;
    private Integer itemCount;
}