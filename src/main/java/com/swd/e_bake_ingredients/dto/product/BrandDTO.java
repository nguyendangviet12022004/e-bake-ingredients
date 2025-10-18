package com.swd.e_bake_ingredients.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO {
    private Integer id;
    private String name;
    private String description;
    private ImageDTO logo;
}