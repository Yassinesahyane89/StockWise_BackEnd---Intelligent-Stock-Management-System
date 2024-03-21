package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.seeders;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers.PermissionFaker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.PermissionEnum;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.PermissionRepository;
import org.springframework.stereotype.Component;

@Component
public class PermissionSeeder {
    private final PermissionFaker permissionFaker;
    private final PermissionRepository permissionRepository;

    public PermissionSeeder(PermissionFaker permissionFaker, PermissionRepository permissionRepository) {
        this.permissionFaker = permissionFaker;
        this.permissionRepository = permissionRepository;
    }

    public void run() {
        for (PermissionEnum permissionEnum : PermissionEnum.values()) {
            permissionRepository.save(permissionFaker.create(permissionEnum));
        }
    }
}
