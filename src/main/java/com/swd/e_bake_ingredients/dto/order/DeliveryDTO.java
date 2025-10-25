package com.swd.e_bake_ingredients.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDTO {
    private Integer id;
    private AddressDTO address;
    private Integer deliveredByStaffId;
    private String deliveredByName;
}