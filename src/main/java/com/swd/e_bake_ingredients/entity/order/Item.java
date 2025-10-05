package com.swd.e_bake_ingredients.entity.order;

import com.swd.e_bake_ingredients.entity.product.ProductVariant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    private Integer id;
    private ProductVariant productVariant;
    private int quantity;
    private double price;
}
