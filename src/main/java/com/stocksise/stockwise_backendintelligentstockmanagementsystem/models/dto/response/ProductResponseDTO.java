package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {
    private Long id;

    private String sku;

    private String name;

    private String slug;

    private String description;

    private String price;

    private Integer quantity;

    private String category;

    private String brand;

    private Long subCategoryId;

    private Long brandId;

     private Long categoryId;

    private String status;

    // mapping from product
    public static ProductResponseDTO fromProduct(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .sku(product.getSku())
                .name(product.getName())
                .slug(product.getSlug())
                .description(product.getDescription())
                .price( "$ " + product.getPrice())
                .quantity(product.getQuantity())
                .category(product.getSubCategory().getSubCategoryName())
                .brand(product.getBrand().getName())
                .subCategoryId(product.getSubCategory().getId())
                .brandId(product.getBrand().getId())
                .categoryId(product.getSubCategory().getParentCategory().getId())
                .status(product.getStatus() ? "ACTIVE" : "INACTIVE")
                .build();
    }

}
