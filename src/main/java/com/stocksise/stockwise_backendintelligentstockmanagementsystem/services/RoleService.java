package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.RoleWithPermissionRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.CreateCategoryResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Role;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.RolePermission;

import java.util.List;

public interface RoleService {
    Role getRoleById(Long id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
    Role addRole(RoleWithPermissionRequestDTO role);
    Role updateRole(RoleWithPermissionRequestDTO role, Long id);
    void deleteRole(Long id);

    // return all permissions
    CreateCategoryResponseDTO getAllPermissions();
}
