package com.swd.e_bake_ingredients.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Unit {
    private Integer id;
    private String name;
    private String description;
}
