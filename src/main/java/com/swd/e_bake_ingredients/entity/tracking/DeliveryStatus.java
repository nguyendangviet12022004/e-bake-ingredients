package com.swd.e_bake_ingredients.entity.tracking;

import com.swd.e_bake_ingredients.constant.DeliveryStatusValue;
import com.swd.e_bake_ingredients.entity.order.Delivery;

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
public class DeliveryStatus extends Status {

    @ManyToOne
    private Delivery delivery;

    @Enumerated(EnumType.STRING)
    private DeliveryStatusValue status;
}
