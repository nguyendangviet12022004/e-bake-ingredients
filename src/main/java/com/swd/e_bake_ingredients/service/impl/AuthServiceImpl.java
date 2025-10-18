package com.swd.e_bake_ingredients.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.swd.e_bake_ingredients.constant.AccountProvider;
import com.swd.e_bake_ingredients.constant.AccountRole;
import com.swd.e_bake_ingredients.dto.auth.AccountDto;
import com.swd.e_bake_ingredients.entity.auth.Customer;
import com.swd.e_bake_ingredients.entity.order.Cart;
import com.swd.e_bake_ingredients.mapper.AccountMapper;
import com.swd.e_bake_ingredients.repository.AccountRepository;
import com.swd.e_bake_ingredients.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(AccountDto accountdto, AccountRole role, AccountProvider provider) {

        switch (role) {
            case AccountRole.ROLE_CUSTOMER:
                Customer account = AccountMapper.toCustomer(accountdto);
                account.setCart(new Cart());

                // modify account entity
                account.setPassword(passwordEncoder.encode(account.getPassword()));
                account.setActivate(true);
                account.setProvider(provider);
                account.setRole(role);

                System.out.println(account);
                // save to db
                accountRepository.save(account);
                break;

            default:
                break;
        }

    }

    @Override
    public boolean checkEmailExists(String email) {
        return accountRepository.existsByEmail(email);
    }

}
