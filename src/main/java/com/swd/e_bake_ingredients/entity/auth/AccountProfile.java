package com.swd.e_bake_ingredients.entity.auth;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountProfile {
    private String phoneNumber;
    private boolean gender;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
