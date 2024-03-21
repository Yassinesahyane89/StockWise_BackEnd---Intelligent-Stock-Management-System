package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Brand;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Product;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.SubCategory;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDTO {

    @NotNull(message = "Product name is required")
    private String name;

    @NotNull(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    private Double price;

    @NotNull(message = "Quantity is required")
    private Integer quantity;

    @NotNull(message = "Sub Category Id is required")
    private Long subCategoryId;

    @NotNull(message = "Brand Id is required")
    private Long brandId;

    @NotNull(message = "Status is required")
    private String status;

    // mapping to product
    public static Product toProduct(ProductRequestDTO productRequestDTO) {
        return Product.builder()
                .name(productRequestDTO.getName())
                .description(productRequestDTO.getDescription())
                .price(productRequestDTO.getPrice())
                .quantity(productRequestDTO.getQuantity())
                .subCategory(
                        SubCategory.builder()
                                .id(productRequestDTO.getSubCategoryId())
                                .build()
                )
                .brand(
                        Brand.builder()
                                .id(productRequestDTO.getBrandId())
                                .build()
                )
                .status(Objects.equals(productRequestDTO.getStatus(), "Active"))
                .build();
    }


    // test data for postman

}
