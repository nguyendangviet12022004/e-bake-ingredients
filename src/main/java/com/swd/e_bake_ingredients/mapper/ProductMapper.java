package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.product.ProductDTO;
import com.swd.e_bake_ingredients.entity.product.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    public static ProductDTO toDTO(Product entity) {
        if (entity == null)
            return null;
        return ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .unitPrice(entity.getUnitPrice())
                .stock(entity.getStock())
                .discount(entity.getDiscount())
                .images(entity.getImages().stream()
                        .map(ImageMapper::toDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    public static Product toEntity(ProductDTO dto) {
        if (dto == null)
            return null;
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .unitPrice(dto.getUnitPrice())
                .stock(dto.getStock())
                // .images(dto.getImages().stream()
                // .map(ImageMapper::toEntity)
                // .collect(Collectors.toList()))
                .build();
    }

    public static List<ProductDTO> toDTOList(List<Product> entities) {
        if (entities == null)
            return null;
        return entities.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Product> toEntityList(List<ProductDTO> dtos) {
        if (dtos == null)
            return null;
        return dtos.stream()
                .map(ProductMapper::toEntity)
                .collect(Collectors.toList());
    }
}