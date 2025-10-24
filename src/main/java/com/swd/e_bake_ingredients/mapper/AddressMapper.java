package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.order.AddressDTO;
import com.swd.e_bake_ingredients.entity.order.Address;

import java.util.List;
import java.util.stream.Collectors;

public class AddressMapper {

    public static AddressDTO toDTO(Address e) {
        if (e == null) return null;
        return AddressDTO.builder()
                .id(e.getId())
                .fullName(e.getFullName())
                .phoneNumber(e.getPhoneNumber())
                .addressLine(e.getAddressLine())
                .ward(e.getWard())
                .district(e.getDistrict())
                .city(e.getCity())
                .isDefault(e.getIsDefault())
                .build();
    }

    public static Address toEntity(AddressDTO d) {
        if (d == null) return null;
        Address a = new Address();
        a.setId(d.getId());
        a.setFullName(d.getFullName());
        a.setPhoneNumber(d.getPhoneNumber());
        a.setAddressLine(d.getAddressLine());
        a.setWard(d.getWard());
        a.setDistrict(d.getDistrict());
        a.setCity(d.getCity());
        a.setIsDefault(d.getIsDefault() != null ? d.getIsDefault() : false);
        return a;
    }

    public static List<AddressDTO> toDTOList(List<Address> list) {
        return list == null ? null : list.stream().map(AddressMapper::toDTO).collect(Collectors.toList());
    }
}