package com.swd.e_bake_ingredients.entity.order;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.swd.e_bake_ingredients.entity.auth.Customer;
import com.swd.e_bake_ingredients.entity.tracking.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
@EntityListeners(AuditingEntityListener.class)

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> items;

    @OneToOne(cascade = CascadeType.ALL)
    private Delivery delivery;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    @OneToOne(cascade = CascadeType.ALL)
    private OrderStatus currentStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderStatus> statusHistory;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public double getTotal() {
        // calculate total of order
        return this.items.stream().map(i -> i.getQuantity() * i.getUnitPrice()).reduce(0.0, Double::sum);
    }
}
