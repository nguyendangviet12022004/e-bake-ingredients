package com.swd.e_bake_ingredients.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.swd.e_bake_ingredients.dto.order.OrderCreateDTO;
import com.swd.e_bake_ingredients.dto.order.OrderDTO;

public interface OrderService {

    OrderDTO prepareOrderForCreation(List<Integer> selectedItemIds, Authentication authentication);

    OrderDTO createOrder(OrderCreateDTO dto, Authentication authentication);
}