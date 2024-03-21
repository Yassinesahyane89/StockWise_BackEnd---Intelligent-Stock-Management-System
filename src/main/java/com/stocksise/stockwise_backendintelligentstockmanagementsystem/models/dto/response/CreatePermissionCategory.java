package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreatePermissionCategory {
    private String permissionCategory;
    private List<CreatePermissionResponseDTO> values;
}
