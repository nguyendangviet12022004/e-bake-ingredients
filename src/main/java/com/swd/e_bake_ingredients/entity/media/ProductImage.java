package com.swd.e_bake_ingredients.entity.media;

import com.swd.e_bake_ingredients.entity.product.ProductVariant;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class ProductImage extends Image {
    @ManyToOne
    private ProductVariant productVariant;
}
