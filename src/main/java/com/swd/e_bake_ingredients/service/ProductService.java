package com.swd.e_bake_ingredients.service;

import java.util.List;

import com.swd.e_bake_ingredients.dto.product.ProductDTO;

public interface ProductService {
    List<ProductDTO> getAllProducts();
}