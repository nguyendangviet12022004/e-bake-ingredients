package com.swd.e_bake_ingredients.entity.tracking;

import com.swd.e_bake_ingredients.constant.OrderStatusValue;
import com.swd.e_bake_ingredients.entity.order.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
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
public class OrderStatus extends Status {
    @ManyToOne
    private Order order;

    @Enumerated(EnumType.STRING)
    private OrderStatusValue status;
}
