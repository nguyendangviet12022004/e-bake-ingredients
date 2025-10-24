package com.swd.e_bake_ingredients.service;

import com.swd.e_bake_ingredients.dto.order.AddressDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface AddressService {
    List<AddressDTO> getCurrentAddresses(Authentication authentication);
    AddressDTO addAddress(AddressDTO dto, Authentication authentication);
}