package com.swd.e_bake_ingredients.service;

import java.util.List;

import com.swd.e_bake_ingredients.dto.product.BrandDTO;

public interface BrandService {
    List<BrandDTO> getAllBrands();
}