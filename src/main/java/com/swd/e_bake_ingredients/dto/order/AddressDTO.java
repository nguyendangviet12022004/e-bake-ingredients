package com.swd.e_bake_ingredients.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String addressLine;
    private String ward;
    private String district;
    private String city;
    private Boolean isDefault;
}