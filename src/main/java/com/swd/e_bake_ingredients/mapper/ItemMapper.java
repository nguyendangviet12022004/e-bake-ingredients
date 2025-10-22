package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.order.ItemDTO;
import com.swd.e_bake_ingredients.entity.order.Item;
import com.swd.e_bake_ingredients.entity.product.Product;

public class ItemMapper {

    public static ItemDTO toDTO(Item entity) {
        if (entity == null)
            return null;

        Product p = entity.getProduct();
        Double unitPrice = null;

        if (p != null) {
            // prefer item.unitPrice if present, otherwise use product.unitPrice
            unitPrice = entity.getUnitPrice() != null ? entity.getUnitPrice() : p.getUnitPrice();
        } else {
            unitPrice = entity.getUnitPrice();
        }

        Integer qty = entity.getQuantity();
        Double subtotal = null;
        if (unitPrice != null && qty != null) {
            subtotal = unitPrice * qty;
        } else {
            subtotal = entity.getUnitPrice() * entity.getQuantity();
        }

        return ItemDTO.builder()
                .id(entity.getId())
                .product(ProductMapper.toDTO(p))
                .unitPrice(unitPrice)
                .quantity(qty)
                .subtotal(subtotal)
                .build();
    }
}