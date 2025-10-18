package com.swd.e_bake_ingredients.entity.auth;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
@Entity
public class Admin extends Account {
}
