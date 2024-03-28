package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Category;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.SubCategory;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class  SubCategoryRequestDTO {
    @NotNull(message = "Sub Category name is required")
    private String subCategoryName;

    @NotNull(message = "Description is required")
    private String description;

    @NotNull(message = "Parent Category Id is required")
    private Long parentCategoryId;

    // mapping to category
    public static SubCategory toSubCategory(SubCategoryRequestDTO subCategoryRequestDTO) {
        return SubCategory.builder()
                .subCategoryName(subCategoryRequestDTO.getSubCategoryName())
                .description(subCategoryRequestDTO.getDescription())
                .parentCategory(
                        Category.builder()
                                .id(subCategoryRequestDTO.getParentCategoryId())
                                .build()
                )
                .build();
    }

}
