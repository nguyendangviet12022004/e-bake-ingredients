package com.swd.e_bake_ingredients.entity.product;

import java.time.LocalDateTime;
import java.util.List;

import com.swd.e_bake_ingredients.entity.media.ProductImage;

import jakarta.persistence.Entity;
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
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int stock;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Unit unit;

    private double unitPrice;

    private double discount;

    @OneToMany(mappedBy = "productVariant")
    List<ProductImage> images;
}
