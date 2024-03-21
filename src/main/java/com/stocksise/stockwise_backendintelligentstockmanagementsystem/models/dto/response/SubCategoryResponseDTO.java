package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.SubCategory;
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
public class SubCategoryResponseDTO {
    private Long id;

    private String categoryName;

    private String categoryCode;

    private String parentCategory;

    private String description;

    private String createdOn;

    // mapping from subcategory
    public static SubCategoryResponseDTO fromSubCategory(SubCategory subCategory) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.US);

        return SubCategoryResponseDTO.builder()
                .id(subCategory.getId())
                .categoryName(subCategory.getSubCategoryName())
                .categoryCode(subCategory.getSubCategoryCode())
                .parentCategory(subCategory.getParentCategory().getName())
                .description(subCategory.getDescription())
                .createdOn(subCategory.getCreatedAt().format(dateFormatter))
                .build();
    }

}
