package com.swd.e_bake_ingredients.entity.auth;

import com.swd.e_bake_ingredients.constant.AccountProvider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Account {
    private Integer id;

    private String email;

    private String password;

    private AccountRole role;

    private AccountProvider provider;

    private AccountProfile detail;

    private boolean isActivate;
}
