package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.product.BrandDTO;
import com.swd.e_bake_ingredients.entity.product.Brand;

import java.util.List;
import java.util.stream.Collectors;

public class BrandMapper {
    public static BrandDTO toDTO(Brand entity) {
        if (entity == null)
            return null;
        return BrandDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }

    public static Brand toEntity(BrandDTO dto) {
        if (dto == null)
            return null;
        return Brand.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                // .logo(ImageMapper.toEntity(dto.getLogo()))
                .build();
    }

    public static List<BrandDTO> toDTOList(List<Brand> entities) {
        if (entities == null)
            return null;
        return entities.stream()
                .map(BrandMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Brand> toEntityList(List<BrandDTO> dtos) {
        if (dtos == null)
            return null;
        return dtos.stream()
                .map(BrandMapper::toEntity)
                .collect(Collectors.toList());
    }
}