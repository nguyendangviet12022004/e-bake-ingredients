package com.swd.e_bake_ingredients.entity.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
    private String id;

    private String method;

    private Double amount;

}
