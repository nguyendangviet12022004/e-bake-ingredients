package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.order.CartDTO;
import com.swd.e_bake_ingredients.entity.order.Cart;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {

    public static CartDTO toDTO(Cart entity) {
        if (entity == null)
            return null;

        List<com.swd.e_bake_ingredients.dto.order.ItemDTO> items = Collections.emptyList();
        if (entity.getItems() != null) {
            items = entity.getItems().stream()
                    .map(com.swd.e_bake_ingredients.mapper.ItemMapper::toDTO)
                    .collect(Collectors.toList());
        }

        Double total = 0.0;

        total = items.stream()
                .filter(i -> i.getSubtotal() != null)
                .mapToDouble(i -> i.getSubtotal())
                .sum();

        return CartDTO.builder()
                .id(entity.getId())
                .items(items)
                .total(total)
                .build();
    }
}