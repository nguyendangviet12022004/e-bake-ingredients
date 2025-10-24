package com.swd.e_bake_ingredients.controller;

import com.swd.e_bake_ingredients.dto.order.AddressDTO;
import com.swd.e_bake_ingredients.service.AddressService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account/addresses")
@PreAuthorize("hasRole('CUSTOMER')")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public String listAddresses(Model model, Authentication authentication) {
        List<AddressDTO> addresses = addressService.getCurrentAddresses(authentication);
        model.addAttribute("addresses", addresses);
        model.addAttribute("newAddress", new AddressDTO());
        return "account/address";
    }

    @PostMapping("/add")
    public String addAddress(@ModelAttribute("newAddress") AddressDTO dto, Authentication authentication) {
        addressService.addAddress(dto, authentication);
        return "redirect:/account/addresses";
    }
}