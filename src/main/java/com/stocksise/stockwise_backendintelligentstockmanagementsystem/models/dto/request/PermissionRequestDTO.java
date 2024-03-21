package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PermissionRequestDTO {
    private Long id;
    private String permissionName;
    private Boolean isRoleHasPermission;
}
