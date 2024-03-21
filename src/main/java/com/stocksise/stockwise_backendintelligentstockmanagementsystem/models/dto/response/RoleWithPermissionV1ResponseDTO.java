package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Permission;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Role;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoleWithPermissionV1ResponseDTO {
    private Long id;
    private String roleName;
    private List<PermissionCategoryDTO> permissions;

    // getters and setters

    // from Role entity to RoleWithPermissionResponseDTO
    public static RoleWithPermissionV1ResponseDTO fromRole(Role role) {
        List<PermissionResponseDTO> permissionResponseDTOList = PermissionResponseDTO.fromPermission(role.getRolePermissions());

        // Group permissions by permissionCategory
        Map<String, List<PermissionResponseDTO>> permissionsMap = permissionResponseDTOList.stream()
                .collect(Collectors.groupingBy(PermissionResponseDTO::getPermissionCategory));

        List<PermissionCategoryDTO> permissionCategoryDTOList = permissionsMap.entrySet().stream()
                .map(entry -> new PermissionCategoryDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return RoleWithPermissionV1ResponseDTO.builder()
                .id(role.getId())
                .roleName(role.getName())
                .permissions(permissionCategoryDTOList)
                .build();
    }
}
