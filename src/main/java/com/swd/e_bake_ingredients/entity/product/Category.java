package com.swd.e_bake_ingredients.entity.product;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    private Integer id;
    private String name;
    private String description;
    private Category parrent;
    private List<Category> children;
}
