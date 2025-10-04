package com.swd.e_bake_ingredients.entity.order;

import com.swd.e_bake_ingredients.entity.auth.Staff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transport {
    private String id;
    private Address address;
    private Staff deliveriedBy;
}
