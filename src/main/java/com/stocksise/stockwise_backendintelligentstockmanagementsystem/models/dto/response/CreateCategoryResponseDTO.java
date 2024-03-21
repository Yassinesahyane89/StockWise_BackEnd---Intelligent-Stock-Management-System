package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Permission;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.PermissionRepository;
import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateCategoryResponseDTO {

    private String roleName;
    private List<CreatePermissionCategory> permissions;

    public static CreateCategoryResponseDTO createCategoryResponseDTO(List<Permission> permissionList) {
        List<CreatePermissionResponseDTO> permissionResponseDTOList = CreatePermissionResponseDTO.createPermissionResponseDTO(permissionList);

        // Group permissions by permissionCategory
        Map<String, List<CreatePermissionResponseDTO>> permissionsMap = permissionResponseDTOList.stream()
                .collect(Collectors.groupingBy(CreatePermissionResponseDTO::getPermissionCategory));

        List<CreatePermissionCategory> permissionCategoryDTOList = permissionsMap.entrySet().stream()
                .map(entry -> new CreatePermissionCategory(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return CreateCategoryResponseDTO.builder()
                .permissions(permissionCategoryDTOList)
                .build();
    }
}
