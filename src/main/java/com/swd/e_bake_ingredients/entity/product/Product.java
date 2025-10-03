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
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Category category;
    private Brand brand;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private double vote;
}
