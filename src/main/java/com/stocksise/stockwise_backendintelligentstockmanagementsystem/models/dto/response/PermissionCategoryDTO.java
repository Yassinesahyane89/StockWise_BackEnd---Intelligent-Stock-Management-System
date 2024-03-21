package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PermissionCategoryDTO {

    private String permissionCategory;
    private List<PermissionResponseDTO> values;
}
