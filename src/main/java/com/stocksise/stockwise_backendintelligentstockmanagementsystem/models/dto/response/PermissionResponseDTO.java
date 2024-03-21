package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Permission;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.RolePermission;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PermissionResponseDTO {
    private Long id;
    private String permissionCategory;
    private String permissionName;
    private Boolean isRoleHasPermission;

    // mapping from PermissionEnum to PermissionResponseDTO
    public static List<PermissionResponseDTO> fromPermission(List<RolePermission> rolePermissions){
        return rolePermissions.stream().map(rolePermission -> PermissionResponseDTO.builder()
                .id(rolePermission.getPermission().getId())
                .permissionCategory(rolePermission.getPermission().getPermissionCategory())
                .permissionName(rolePermission.getPermission().getName().name())
                .isRoleHasPermission(rolePermission.getIsRoleHasPermission())
                .build()).toList();
    }
}
