package com.swd.e_bake_ingredients.mapper;

import com.swd.e_bake_ingredients.dto.product.ImageDTO;
import com.swd.e_bake_ingredients.entity.media.Image;

public class ImageMapper {
    public static ImageDTO toDTO(Image entity) {
        if (entity == null)
            return null;
        return ImageDTO.builder()
                .id(entity.getId())
                .src(entity.getSrc())
                .altText(entity.getAltText())
                .build();
    }

    public static Image toEntity(ImageDTO dto) {
        if (dto == null)
            return null;
        return Image.builder()
                .id(dto.getId())
                .src(dto.getSrc())
                .altText(dto.getAltText())
                .build();
    }
}