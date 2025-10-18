package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.product.CategoryDTO;
import com.swd.e_bake_ingredients.entity.product.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category entity) {
        if (entity == null)
            return null;
        return CategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .image(ImageMapper.toDTO(entity.getImage()))
                .build();
    }

    public static Category toEntity(CategoryDTO dto) {
        if (dto == null)
            return null;
        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                // .image(ImageMapper.toEntity(dto.getImage()))
                .build();
    }

    public static List<CategoryDTO> toDTOList(List<Category> entities) {
        if (entities == null)
            return null;
        return entities.stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Category> toEntityList(List<CategoryDTO> dtos) {
        if (dtos == null)
            return null;
        return dtos.stream()
                .map(CategoryMapper::toEntity)
                .collect(Collectors.toList());
    }
}