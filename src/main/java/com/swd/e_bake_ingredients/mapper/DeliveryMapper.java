package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.order.DeliveryDTO;
import com.swd.e_bake_ingredients.entity.order.Delivery;

public class DeliveryMapper {
    public static DeliveryDTO toDTO(Delivery e) {
        if (e == null)
            return null;
        return DeliveryDTO.builder()
                .id(e.getId())
                .address(AddressMapper.toDTO(e.getAddress()))
                .deliveredByStaffId(e.getDeliveriedBy() != null ? e.getDeliveriedBy().getId() : null)
                .deliveredByName(
                        e.getDeliveriedBy() != null
                                ? e.getDeliveriedBy().getProfile().getFirstName() + " "
                                        + e.getDeliveriedBy().getProfile().getLastName()
                                : null)
                .build();
    }
}