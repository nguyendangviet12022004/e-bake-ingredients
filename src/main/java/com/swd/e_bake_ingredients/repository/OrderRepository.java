package com.swd.e_bake_ingredients.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swd.e_bake_ingredients.entity.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Add custom queries if needed
    List<Order> findByCustomerIdOrderByCreatedAtDesc(Integer customerId);

}