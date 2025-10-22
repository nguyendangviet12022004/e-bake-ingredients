package com.swd.e_bake_ingredients.service;

import org.springframework.security.core.Authentication;

import com.swd.e_bake_ingredients.dto.order.CartDTO;

public interface CartService {
    CartDTO getCart(Authentication authentication);

    CartDTO addItem(Integer productId, Authentication authentication);
}