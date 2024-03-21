package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers;

import com.github.javafaker.Faker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Permission;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Role;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.RolePermission;
import org.springframework.stereotype.Component;

@Component
public class RolePermissionFaker {
    private final Faker faker;

    public RolePermissionFaker() {
        this.faker = new Faker();
    }

    public RolePermission create(Role role, Permission permission) {
        return RolePermission.builder()
                .role(role)
                .permission(permission)
                .isRoleHasPermission(faker.bool().bool())
                .build();
    }
}
