package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers;

import com.github.javafaker.Faker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandFaker {
    private final Faker faker;

    public BrandFaker() {
        this.faker = new Faker();
    }

    public Brand create(String name, String website, String email, Boolean status) {
        return Brand.builder()
                .name(name)
                .website(website)
                .email(email)
                .status(status)
                .build();
    }
}
