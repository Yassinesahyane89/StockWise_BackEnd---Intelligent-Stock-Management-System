package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PermissionCategoryDTO {
    private String permissionCategory;
    private List<PermissionRequestDTO> values;
}
