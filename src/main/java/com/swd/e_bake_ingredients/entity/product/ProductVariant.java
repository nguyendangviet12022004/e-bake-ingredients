package com.swd.e_bake_ingredients.entity.product;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductVariant {
    private Integer id;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int stock;
    private Unit unit;
    private double unitPrice;
    private double discount;

    // images
}
