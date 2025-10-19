package com.swd.e_bake_ingredients.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swd.e_bake_ingredients.entity.auth.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByProfilePhoneNumber(String phone);
}
