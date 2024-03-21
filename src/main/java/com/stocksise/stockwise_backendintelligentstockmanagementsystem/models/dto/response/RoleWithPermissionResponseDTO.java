package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Permission;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Role;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.PermissionEnum;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoleWithPermissionResponseDTO {
    private Long id;
    private String roleName;
    private Map<String, Map<PermissionEnum, Boolean>> permissions;

    // from Role entity to RoleWithPermissionResponseDTO
//    public static RoleWithPermissionResponseDTO fromRole(Role role){
//        // Initialize permissions map
//        Map<String, Map<PermissionEnum, Boolean>> groupedPermissions = new HashMap<>();
//        for (PermissionEnum permissionEnum : PermissionEnum.values()) {
//            groupedPermissions.put(permissionEnum.getPermissionCategory(), new HashMap<>());
//        }
//
//        for (PermissionEnum permissionEnum : PermissionEnum.values()) {
//            groupedPermissions.get(permissionEnum.getPermissionCategory()).put(permissionEnum, false);
//        }
//
//        // Set permissions based on role's permissions
//        for (Permission permission : role.getPermissions()) {
//            groupedPermissions.get(permission.getPermissionCategory()).put(permission.getName(), true);
//        }
//
//        return RoleWithPermissionResponseDTO.builder()
//                .id(role.getId())
//                .roleName(role.getName())
//                .permissions(groupedPermissions)
//                .build();
//    }


}
