package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Permission;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreatePermissionResponseDTO {
    private Long id;
    private String permissionCategory;
    private String permissionName;
    private Boolean isRoleHasPermission;

    public static List<CreatePermissionResponseDTO> createPermissionResponseDTO(List<Permission> permissionList) {
        return permissionList.stream().map(permission -> CreatePermissionResponseDTO.builder()
                .id(permission.getId())
                .permissionCategory(permission.getPermissionCategory())
                .permissionName(permission.getName().name())
                .isRoleHasPermission(false)
                .build()).toList();
    }
}
