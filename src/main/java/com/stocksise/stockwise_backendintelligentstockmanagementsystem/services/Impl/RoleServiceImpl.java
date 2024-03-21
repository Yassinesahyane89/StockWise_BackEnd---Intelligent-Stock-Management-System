package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.Impl;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.OperationException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.ResourceNotFoundException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.RoleWithPermissionRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.CreateCategoryResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Role;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.RolePermission;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.PermissionRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.RolePermissionRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.RoleRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RolePermissionRepository rolePermissionRepository;
    private final PermissionRepository permissionRepository;

    public RoleServiceImpl(RoleRepository roleRepository, RolePermissionRepository rolePermissionRepository, PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.rolePermissionRepository = rolePermissionRepository;
        this.permissionRepository = permissionRepository;
    }
    @Override
    public Role getRoleById(Long id) {
        return roleRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Role with id " + id + " not found")
                );
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository
                .findByName(name)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Role with name " + name + " not found")
                );
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role addRole(RoleWithPermissionRequestDTO role) {
        // check if role with name already exists
        if (roleRepository.findByName(role.getRoleName()).isPresent()) {
            throw new OperationException("Role with name " + role.getRoleName() + " already exists");
        }

        // mapping roleRequestDTO to role
        Role newRole = role.toRole();

        // save role to database
        Role newRole1 =  roleRepository.save(newRole);

        // save role with permissions to database
        List<RolePermission> rolePermissions = rolePermissionRepository.saveAll(role.toRoleWithPermissions(newRole1));

        // set role with permissions to role
        newRole1.setRolePermissions(rolePermissions);

        return newRole1;
    }

    @Override
    public Role updateRole(RoleWithPermissionRequestDTO role, Long id) {
        Role existingRole = getRoleById(id);
        // check if role with name already exists and the name is not the same as the existing role name
        if(roleRepository.findByName(role.getRoleName()).isPresent() && !existingRole.getName().equals(role.getRoleName())){
            throw new OperationException("Role with name " + role.getRoleName() + " already exists");
        }

        existingRole.setName(role.getRoleName());

        // update role with permissions
        List<RolePermission> rolePermissions = rolePermissionRepository.saveAll(role.toRoleWithPermissions(existingRole));

        // set role with permissions to role
        existingRole.setRolePermissions(rolePermissions);

        return roleRepository.save(existingRole);
    }

    @Override
    public void deleteRole(Long id) {
        getRoleById(id);
        roleRepository.deleteById(id);
    }

    // return all permissions
    @Override
    public CreateCategoryResponseDTO getAllPermissions() {
        return CreateCategoryResponseDTO.createCategoryResponseDTO(permissionRepository.findAll());
    }
}
