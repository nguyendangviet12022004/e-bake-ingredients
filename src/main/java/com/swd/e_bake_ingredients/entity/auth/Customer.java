package com.swd.e_bake_ingredients.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Customer extends Account {
    // addresses, wallet, ...
}
