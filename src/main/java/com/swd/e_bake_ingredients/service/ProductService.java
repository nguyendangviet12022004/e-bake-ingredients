package com.swd.e_bake_ingredients.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.swd.e_bake_ingredients.entity.product.Product;

public interface ProductService {
    Page<Product> getProducts(List<Integer> categoryIds, List<Integer> brandIds, Double minPrice, Double maxPrice,
            Pageable pageable);

}