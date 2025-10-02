package com.swd.e_bake_ingredients.entity.auth;

import com.swd.e_bake_ingredients.constant.AccountRoleName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRole {
    private Integer id;

    private AccountRoleName name;
}
