package com.swd.e_bake_ingredients.entity.auth;

import java.util.List;

import com.swd.e_bake_ingredients.entity.order.Address;
import com.swd.e_bake_ingredients.entity.order.Cart;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@Entity
public class Customer extends Account {
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    @OneToOne
    private Cart cart;
}
