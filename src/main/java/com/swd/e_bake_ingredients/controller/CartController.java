package com.swd.e_bake_ingredients.controller;

import com.swd.e_bake_ingredients.dto.order.CartDTO;
import com.swd.e_bake_ingredients.service.CartService;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public String viewCart(Model model, Authentication authentication) {
        CartDTO cart = cartService.getCart(authentication);
        model.addAttribute("cart", cart);
        return "order/cart";
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addItem(@RequestParam("productId") Integer productId,
            Authentication authentication) {
        CartDTO cart = cartService.addItem(productId, authentication);
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Added to cart");
        body.put("cart", cart);
        return ResponseEntity.ok(body);
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateItem(@RequestBody Map<String, Object> payload,
            Authentication authentication) {
        Integer itemId = ((Number) payload.get("itemId")).intValue();
        Integer quantity = ((Number) payload.get("quantity")).intValue();
        CartDTO cart = cartService.updateItemQuantity(itemId, quantity, authentication);

        Map<String, Object> resp = new HashMap<>();
        resp.put("success", true);
        resp.put("itemId", itemId);
        // compute item subtotal for response
        cart.getItems().stream()
                .filter(i -> i.getId().equals(itemId))
                .findFirst()
                .ifPresent(i -> resp.put("itemSubtotal", i.getSubtotal()));
        resp.put("cartTotal", cart.getTotal());
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/remove")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> removeItem(@RequestBody Map<String, Object> payload,
            Authentication authentication) {
        Integer itemId = ((Number) payload.get("itemId")).intValue();
        CartDTO cart = cartService.removeItem(itemId, authentication);
        Map<String, Object> resp = new HashMap<>();
        resp.put("success", true);
        resp.put("itemId", itemId);
        resp.put("cartTotal", cart.getTotal());
        return ResponseEntity.ok(resp);
    }
}