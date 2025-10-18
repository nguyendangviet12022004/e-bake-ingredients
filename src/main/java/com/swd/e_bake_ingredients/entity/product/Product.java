package com.swd.e_bake_ingredients.entity.product;

import java.time.LocalDateTime;
import java.util.List;

import com.swd.e_bake_ingredients.entity.media.ProductImage;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brand brand;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private double vote;

    @ManyToOne
    private Unit unit;

    private double unitPrice;

    private double discount;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    List<ProductImage> images;

    private int stock;

    private double price;
}
