package com.swd.e_bake_ingredients.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.swd.e_bake_ingredients.constant.PaymentMethod;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDTO {
    private List<Integer> selectedItemIds;
    private Integer addressId;
    private PaymentMethod paymentMethod;
}