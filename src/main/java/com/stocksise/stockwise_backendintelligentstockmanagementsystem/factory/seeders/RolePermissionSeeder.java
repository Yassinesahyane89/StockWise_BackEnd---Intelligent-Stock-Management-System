package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.seeders;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers.RolePermissionFaker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Permission;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Role;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.PermissionRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.RolePermissionRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.RoleRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolePermissionSeeder {
    private final RolePermissionFaker rolePermissionFaker;
    private final RolePermissionRepository rolePermissionRepository;
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;

    public RolePermissionSeeder(RolePermissionFaker rolePermissionFaker, RolePermissionRepository rolePermissionRepository, PermissionRepository permissionRepository, RoleRepository roleRepository) {
        this.rolePermissionFaker = rolePermissionFaker;
        this.rolePermissionRepository = rolePermissionRepository;
        this.permissionRepository = permissionRepository;
        this.roleRepository = roleRepository;
    }

    public void seed() {
        // get all roles
        List<Role> roles = roleRepository.findAll();

        // get all permissions
        List<Permission> permissions = permissionRepository.findAll();

        // loop through all roles
        for (Role role : roles) {
            // loop through all permissions
            for (Permission permission : permissions) {
                // create role permission
                rolePermissionRepository.save(rolePermissionFaker.create(role, permission));
            }
        }
    }
}
