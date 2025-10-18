package com.swd.e_bake_ingredients.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import com.swd.e_bake_ingredients.dto.auth.AccountDto;
import com.swd.e_bake_ingredients.entity.auth.Account;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
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
    public String register(@RequestBody Account account) {
        System.out.println(account);
        return "home/index";
    }

}
