package com.swd.e_bake_ingredients.entity.order;

import java.util.List;

import com.swd.e_bake_ingredients.entity.auth.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private Integer id;
    private Customer customer;
    private List<Item> items;
    private Transport transport;
}
