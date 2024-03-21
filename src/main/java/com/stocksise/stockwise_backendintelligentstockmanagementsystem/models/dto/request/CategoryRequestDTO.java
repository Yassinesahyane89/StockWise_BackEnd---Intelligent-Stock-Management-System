package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Category;
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
public class CategoryRequestDTO {
    @NotNull(message = "Category name is required")
    String categoryName;

    @NotNull(message = "Status is required")
    String status;

    // mapping to category
    public static Category toCategory(CategoryRequestDTO categoryRequestDTO) {
        return Category.builder()
                .name(categoryRequestDTO.getCategoryName())
                .status(Objects.equals(categoryRequestDTO.getStatus(), "Active"))
                .build();
    }
}
