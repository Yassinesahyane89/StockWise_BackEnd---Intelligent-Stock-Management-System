package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers;

import com.github.javafaker.Faker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Role;
import org.springframework.stereotype.Component;


@Component
public class RoleFaker {
    private final Faker faker;

    public RoleFaker() {
        this.faker = new Faker();
    }

    public Role create(String roleName) {
        return Role.builder()
                .name(roleName)
                .build();
    }
}
