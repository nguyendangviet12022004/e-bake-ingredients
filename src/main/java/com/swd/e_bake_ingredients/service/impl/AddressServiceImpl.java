package com.swd.e_bake_ingredients.service.impl;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swd.e_bake_ingredients.config.security.AccountUserDetails;
import com.swd.e_bake_ingredients.dto.order.AddressDTO;
import com.swd.e_bake_ingredients.entity.auth.Customer;
import com.swd.e_bake_ingredients.entity.order.Address;
import com.swd.e_bake_ingredients.mapper.AddressMapper;
import com.swd.e_bake_ingredients.repository.AddressRepository;
import com.swd.e_bake_ingredients.service.AddressService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private Integer resolveAccountId(Authentication authentication) {

        Object p = authentication.getPrincipal();
        if (p instanceof AccountUserDetails) {
            return ((AccountUserDetails) p).getAccount().getId();
        }
        return null;
    }

    @Override
    public List<AddressDTO> getCurrentAddresses(Authentication authentication) {
        Integer accountId = resolveAccountId(authentication);
        if (accountId == null)
            return java.util.Collections.emptyList();
        List<Address> addresses = addressRepository.findByCustomerIdOrderByIsDefaultDescIdDesc(accountId);
        return AddressMapper.toDTOList(addresses);
    }

    @Override
    @Transactional
    public AddressDTO addAddress(AddressDTO dto, Authentication authentication) {
        Integer accountId = resolveAccountId(authentication);
        if (accountId == null) {
            throw new IllegalArgumentException("Authentication required");
        }

        Customer customer = Customer.builder().id(accountId).build();
        Address addr = AddressMapper.toEntity(dto);
        addr.setCustomer(customer);

        // if this new address is default, unset other defaults
        if (Boolean.TRUE.equals(addr.getIsDefault())) {
            List<Address> existing = addressRepository.findByCustomerIdOrderByIsDefaultDescIdDesc(accountId);
            for (Address a : existing) {
                if (Boolean.TRUE.equals(a.getIsDefault())) {
                    a.setIsDefault(false);
                    addressRepository.save(a);
                }
            }
        }

        Address saved = addressRepository.save(addr);
        return AddressMapper.toDTO(saved);
    }
}