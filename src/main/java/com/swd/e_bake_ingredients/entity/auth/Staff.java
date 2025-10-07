package com.swd.e_bake_ingredients.entity.auth;

import com.swd.e_bake_ingredients.constant.StaffPosition;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Staff extends Account {
    @Enumerated(EnumType.STRING)
    private StaffPosition position;
    private double salary;
}
