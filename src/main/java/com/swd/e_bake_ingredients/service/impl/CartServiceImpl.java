package com.swd.e_bake_ingredients.service.impl;

import java.util.Collections;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.swd.e_bake_ingredients.dto.order.CartDTO;
import com.swd.e_bake_ingredients.entity.order.Cart;
import com.swd.e_bake_ingredients.entity.order.Item;
import com.swd.e_bake_ingredients.entity.product.Product;
import com.swd.e_bake_ingredients.mapper.CartMapper;
import com.swd.e_bake_ingredients.repository.CartRepository;
import com.swd.e_bake_ingredients.repository.ProductRepository;
import com.swd.e_bake_ingredients.service.CartService;
import com.swd.e_bake_ingredients.config.security.AccountUserDetails;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Override
    public CartDTO getCart(Authentication auth) {

        Object principal = auth.getPrincipal();
        Integer accountId = null;

        if (principal instanceof AccountUserDetails) {
            accountId = ((AccountUserDetails) principal).getAccount().getId();
        } else {
            return CartDTO.builder().items(Collections.emptyList()).total(0.0).build();
        }

        Optional<Cart> cart = this.cartRepository.findByCustomerId(accountId);
        if (cart.isPresent()) {
            return CartMapper.toDTO(cart.get());
        }

        return CartDTO.builder().items(Collections.emptyList()).total(0.0).build();
    }

    @Override
    public CartDTO addItem(Integer productId, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        Integer accountId = null;

        if (principal instanceof AccountUserDetails) {
            accountId = ((AccountUserDetails) principal).getAccount().getId();
        } else {
            return CartDTO.builder().items(Collections.emptyList()).total(0.0).build();
        }

        Optional<Cart> cartOp = this.cartRepository.findByCustomerId(accountId);
        Cart cart = cartOp.get();

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        // find existing item for product
        Item existing = null;
        if (cart.getItems() != null) {
            for (Item it : cart.getItems()) {
                if (it.getProduct() != null && product.getId().equals(it.getProduct().getId())) {
                    existing = it;
                    break;
                }
            }
        }

        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + 1);
            existing.setUnitPrice(product.getUnitPrice());
        } else {
            Item newItem = new Item();
            newItem.setProduct(product);
            newItem.setQuantity(1);
            newItem.setUnitPrice(product.getUnitPrice());
            newItem.setCart(cart);
            cart.getItems().add(newItem);
        }

        cartRepository.save(cart);

        return CartMapper.toDTO(cart);
    }

}