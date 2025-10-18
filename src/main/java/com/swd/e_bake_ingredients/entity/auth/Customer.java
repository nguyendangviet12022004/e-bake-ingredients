package com.swd.e_bake_ingredients.entity.auth;

import java.util.List;

import com.swd.e_bake_ingredients.entity.order.Address;
import com.swd.e_bake_ingredients.entity.order.Cart;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Customer extends Account {
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
}
