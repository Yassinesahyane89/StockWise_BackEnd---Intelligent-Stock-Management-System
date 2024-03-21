
package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PermissionEnum {

    // User Permissions
    USER_READ("user"),
    USER_CREATE("user"),
    USER_UPDATE("user"),
    USER_DELETE("user"),

    // Role Permissions
    ROLE_READ("role"),
    ROLE_CREATE("role"),
    ROLE_UPDATE("role"),
    ROLE_DELETE("role"),

    // Product Permissions
    PRODUCT_READ("product"),
    PRODUCT_CREATE("product"),
    PRODUCT_UPDATE("product"),
    PRODUCT_DELETE("product");

    private final String permissionCategory;
}
