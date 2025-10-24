package com.swd.e_bake_ingredients.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.swd.e_bake_ingredients.dto.product.BrandDTO;
import com.swd.e_bake_ingredients.dto.product.CategoryDTO;
import com.swd.e_bake_ingredients.entity.product.Product;
import com.swd.e_bake_ingredients.mapper.ProductMapper;
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
    public String index(@RequestParam(required = false) List<Integer> categoryIds,
            @RequestParam(required = false) List<Integer> brandIds,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productService.getProducts(categoryIds, brandIds, minPrice, maxPrice, pageable);
        List<CategoryDTO> categories = categoryService.getAllCategories();
        List<BrandDTO> brands = brandService.getAllBrands();

        model.addAttribute("products", productPage.getContent().stream().map(ProductMapper::toDTO).toList());
        model.addAttribute("categories", categories);
        model.addAttribute("brands", brands);

        model.addAttribute("categoryIds", categoryIds != null ? categoryIds : List.of());
        model.addAttribute("brandIds", brandIds != null ? brandIds : List.of());
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("page", productPage);

        return "home/index";
    }

}
