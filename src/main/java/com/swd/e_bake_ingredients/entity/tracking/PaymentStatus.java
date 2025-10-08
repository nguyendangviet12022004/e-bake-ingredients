package com.swd.e_bake_ingredients.entity.tracking;

import com.swd.e_bake_ingredients.constant.PaymentStatusValue;
import com.swd.e_bake_ingredients.entity.order.Payment;

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
public class PaymentStatus extends Status {

    @ManyToOne
    private Payment payment;

    @Enumerated(EnumType.STRING)
    private PaymentStatusValue status;
}
