package com.swd.e_bake_ingredients.dto.auth;

import java.time.LocalDate;

import com.swd.e_bake_ingredients.dto.product.ImageDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountProfileDto {
    private String phoneNumber;

    private boolean gender;

    private String firstName;

    private String lastName;

    private LocalDate dob;

}
