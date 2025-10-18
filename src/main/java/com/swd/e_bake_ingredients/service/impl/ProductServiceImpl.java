package com.swd.e_bake_ingredients.service.impl;

import com.swd.e_bake_ingredients.dto.product.ProductDTO;
import com.swd.e_bake_ingredients.mapper.ProductMapper;
import com.swd.e_bake_ingredients.repository.ProductRepository;
import com.swd.e_bake_ingredients.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        return ProductMapper.toDTOList(productRepository.findAll());
    }
}