package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Permission;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Role;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.RolePermission;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.PermissionEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RoleWithPermissionRequestDTO {
    @NotNull(message = "Role name is required")
    private String roleName;

    private List<PermissionCategoryDTO> permissions;

    // mapping to role
    public Role toRole() {
        return Role.builder()
                .name(this.roleName)
                .build();
    }

    // mapping to role with permissions
    public List<RolePermission> toRoleWithPermissions(Role role) {
        //get permission list
        List<Permission> permissionList = toPermissionList(this.permissions);

        return permissionList.stream()
                .map(permission -> RolePermission.builder()
                        .role(role)
                        .permission(permission)
                        .isRoleHasPermission( this.permissions.stream()
                                .flatMap(permissionCategoryDTO -> permissionCategoryDTO.getValues().stream())
                                .filter(permissionRequestDTO -> permissionRequestDTO.getId().equals(permission.getId()))
                                .findFirst()
                                .map(PermissionRequestDTO::getIsRoleHasPermission)
                                .orElse(false)
                        )
                        .build())
                .collect(Collectors.toList());
    }

    // mapping to permission list
    public List<Permission> toPermissionList(List<PermissionCategoryDTO> permissions) {
        return permissions.stream()
                .map(permissionCategoryDTO -> permissionCategoryDTO.getValues())
                .flatMap(List::stream)
                .map(permissionRequestDTO -> Permission.builder()
                        .id(permissionRequestDTO.getId())
                        .permissionCategory(PermissionEnum.valueOf(permissionRequestDTO.getPermissionName()).getPermissionCategory())
                        .name(PermissionEnum.valueOf(permissionRequestDTO.getPermissionName()))
                        .build())
                .collect(Collectors.toList());
    }
}
