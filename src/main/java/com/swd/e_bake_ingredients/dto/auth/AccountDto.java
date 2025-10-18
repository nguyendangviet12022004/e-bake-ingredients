package com.swd.e_bake_ingredients.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private Integer id;

    private String email;

    private String password;

    private AccountProfileDto profile;
}
