package com.swd.e_bake_ingredients.entity.order;

import java.time.LocalDateTime;
import java.util.List;

import com.swd.e_bake_ingredients.entity.auth.Customer;
import com.swd.e_bake_ingredients.entity.tracking.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<Item> items;

    @OneToOne
    private Delivery delivery;

    @OneToOne
    private Payment payment;

    @OneToOne
    private OrderStatus currentStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderStatus> statusHistory;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
