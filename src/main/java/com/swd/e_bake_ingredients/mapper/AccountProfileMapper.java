package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.auth.AccountProfileDto;
import com.swd.e_bake_ingredients.entity.auth.AccountProfile;

public class AccountProfileMapper {
    public static AccountProfileDto toDTO(AccountProfile entity) {
        if (entity == null)
            return null;
        return AccountProfileDto.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .phoneNumber(entity.getPhoneNumber())
                .gender(entity.isGender())
                .dob(entity.getDob())
                .build();
    }

    public static AccountProfile toEntity(AccountProfileDto dto) {
        if (dto == null)
            return null;
        return AccountProfile.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .phoneNumber(dto.getPhoneNumber())
                .gender(dto.isGender())
                .dob(dto.getDob())
                .build();
    }
}