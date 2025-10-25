package com.swd.e_bake_ingredients.entity.order;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.swd.e_bake_ingredients.constant.PaymentMethod;
import com.swd.e_bake_ingredients.entity.tracking.PaymentStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private PaymentMethod method;

    private Double amount;

    @OneToOne
    private PaymentStatus currentStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payment")
    private List<PaymentStatus> statusHistory;

    @CreatedDate
    private LocalDateTime createdAt;
}
