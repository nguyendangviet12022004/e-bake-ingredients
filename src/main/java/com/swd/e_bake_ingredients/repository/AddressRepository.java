package com.swd.e_bake_ingredients.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swd.e_bake_ingredients.entity.order.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByCustomerIdOrderByIsDefaultDescIdDesc(Integer accountId);
}