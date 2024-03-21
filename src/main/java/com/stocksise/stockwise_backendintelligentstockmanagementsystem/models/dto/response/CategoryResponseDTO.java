package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDTO {
    private Long id;

    private String categoryName;

    private String categorySlug;

    private String createdOn;

    private String status;

    // mapping from category
    public static CategoryResponseDTO fromCategory(Category category) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.US);

        return CategoryResponseDTO.builder()
                .id(category.getId())
                .categoryName(category.getName())
                .categorySlug(category.getSlug())
                .createdOn(category.getCreatedAt().format(dateFormatter))
                .status(category.getStatus() ? "ACTIVE" : "INACTIVE")
                .build();
    }
}
