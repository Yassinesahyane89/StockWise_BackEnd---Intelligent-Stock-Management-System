package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers;

import com.github.javafaker.Faker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Permission;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.PermissionEnum;
import org.springframework.stereotype.Component;

@Component
public class PermissionFaker {
    private final Faker faker;

    public PermissionFaker() {
        this.faker = new Faker();
    }

    public Permission create(PermissionEnum name) {
        return Permission.builder()
                .name(name)
                .permissionCategory(name.getPermissionCategory())
                .build();
    }
}
