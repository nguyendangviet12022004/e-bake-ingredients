package com.swd.e_bake_ingredients.dto.order;

import com.swd.e_bake_ingredients.dto.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Integer id;
    private ProductDTO product;
    private Double unitPrice;
    private Integer quantity;
    private Double subtotal;
}