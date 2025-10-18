package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.auth.AccountDto;
import com.swd.e_bake_ingredients.entity.auth.Account;
import java.util.List;
import java.util.stream.Collectors;

public class AccountMapper {
    public static AccountDto toDTO(Account entity) {
        if (entity == null) return null;
        return AccountDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .profile(AccountProfileMapper.toDTO(entity.getProfile()))
                .build();
    }

    public static Account toEntity(AccountDto dto) {
        if (dto == null) return null;
        return Account.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .profile(AccountProfileMapper.toEntity(dto.getProfile()))
                .build();
    }

    public static List<AccountDto> toDTOList(List<Account> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(AccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Account> toEntityList(List<AccountDto> dtos) {
        if (dtos == null) return null;
        return dtos.stream()
                .map(AccountMapper::toEntity)
                .collect(Collectors.toList());
    }
}