package com.swd.e_bake_ingredients.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import com.swd.e_bake_ingredients.constant.AccountProvider;
import com.swd.e_bake_ingredients.constant.AccountRole;
import com.swd.e_bake_ingredients.dto.auth.AccountDto;
import com.swd.e_bake_ingredients.service.AuthService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("login")
    public String getLoginPage() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("account", new AccountDto());
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(Model model, @Validated @ModelAttribute AccountDto account) {

        if (authService.checkEmailExists(account.getEmail())) {
            model.addAttribute("errMsg", "This email is exsits");
            return "auth/register";
        }

        authService.register(account, AccountRole.ROLE_CUSTOMER, AccountProvider.LOCAL);

        return "redirect:/auth/login";
    }

}
