package com.swd.e_bake_ingredients.service.impl;

import com.swd.e_bake_ingredients.dto.product.CategoryDTO;
import com.swd.e_bake_ingredients.mapper.CategoryMapper;
import com.swd.e_bake_ingredients.repository.CategoryRepository;
import com.swd.e_bake_ingredients.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return CategoryMapper.toDTOList(categoryRepository.findAll());
    }
}