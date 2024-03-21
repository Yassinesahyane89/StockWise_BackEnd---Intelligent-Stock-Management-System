package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.seeders.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainFactory implements CommandLineRunner {
    private final UserSeeder userSeeder;
    private final PermissionSeeder permissionSeeder;
    private final RoleSeeder roleSeeder;
    private final RolePermissionSeeder rolePermissionSeeder;
    private final SubCategorySeeder subCategorySeeder;
    private final CategorySeeder categorySeeder;
    private final BrandSeeder brandSeeder;
    private final ProductSeeder productSeeder;
    private final UnitSeeder unitSeeder;
    private final WarrantySeeder warrantySeeder;


    public MainFactory(UserSeeder userSeeder, PermissionSeeder permissionSeeder, RoleSeeder roleSeeder, RolePermissionSeeder rolePermissionSeeder, SubCategorySeeder subCategorySeeder, CategorySeeder categorySeeder, BrandSeeder brandSeeder, ProductSeeder productSeeder, UnitSeeder unitSeeder, WarrantySeeder warrantySeeder) {
        this.userSeeder = userSeeder;
        this.permissionSeeder = permissionSeeder;
        this.roleSeeder = roleSeeder;
        this.rolePermissionSeeder = rolePermissionSeeder;
        this.subCategorySeeder = subCategorySeeder;
        this.categorySeeder = categorySeeder;
        this.brandSeeder = brandSeeder;
        this.productSeeder = productSeeder;
        this.unitSeeder = unitSeeder;
        this.warrantySeeder = warrantySeeder;
    }

    @Value("${seed.enabled}")
    public Boolean isSeedEnabled;
    @Override
    public void run(String... args) throws Exception {
        if(Boolean.FALSE.equals(isSeedEnabled)) return;
        permissionSeeder.run();
        roleSeeder.run();
        rolePermissionSeeder.seed();
        userSeeder.run(10);
        categorySeeder.run();
        subCategorySeeder.run();
        brandSeeder.run();
        unitSeeder.run();
        productSeeder.run(10);
        warrantySeeder.run();
    }
}
