package com.swd.e_bake_ingredients.service;

import com.swd.e_bake_ingredients.constant.AccountProvider;
import com.swd.e_bake_ingredients.constant.AccountRole;
import com.swd.e_bake_ingredients.dto.auth.AccountDto;

public interface AuthService {
    public void register(AccountDto account, AccountRole role, AccountProvider provider);

    public boolean checkEmailExists(String email);

    public boolean checkPhoneNumberExists(String phone);
}
