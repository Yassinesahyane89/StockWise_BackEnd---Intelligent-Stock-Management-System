package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers;

import com.github.javafaker.Faker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryFaker {
    private final Faker faker;

    public CategoryFaker() {
        this.faker = new Faker();
    }

    public Category create(String name, String slug, Boolean status) {
        return Category.builder()
                .name(name)
                .slug(slug)
                .status(status)
                .build();
    }
}
