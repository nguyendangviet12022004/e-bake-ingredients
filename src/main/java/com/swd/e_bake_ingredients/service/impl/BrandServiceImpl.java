package com.swd.e_bake_ingredients.service.impl;

import com.swd.e_bake_ingredients.dto.product.BrandDTO;
import com.swd.e_bake_ingredients.mapper.BrandMapper;
import com.swd.e_bake_ingredients.repository.BrandRepository;
import com.swd.e_bake_ingredients.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public List<BrandDTO> getAllBrands() {
        return BrandMapper.toDTOList(brandRepository.findAll());
    }
}