package com.swd.e_bake_ingredients.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swd.e_bake_ingredients.dto.product.BrandDTO;
import com.swd.e_bake_ingredients.dto.product.CategoryDTO;
import com.swd.e_bake_ingredients.dto.product.ProductDTO;
import com.swd.e_bake_ingredients.service.BrandService;
import com.swd.e_bake_ingredients.service.CategoryService;
import com.swd.e_bake_ingredients.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;

    private final CategoryService categoryService;

    private final BrandService brandService;

    @GetMapping
    public String index(Model model) {
        List<ProductDTO> products = productService.getAllProducts();
        List<CategoryDTO> categories = categoryService.getAllCategories();
        List<BrandDTO> brands = brandService.getAllBrands();

        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        model.addAttribute("brands", brands);

        return "home/index";
    }

}
