package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers;

import com.github.javafaker.Faker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.*;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.DiscountType;
import org.springframework.stereotype.Component;

@Component
public class ProductFaker {
    private final Faker faker;

    public ProductFaker() {
        this.faker = new Faker();
    }

    public Product create(Brand brand, SubCategory subCategory, Unit unit) {
        return Product.builder()
                .sku(faker.code().ean13())
                .name(faker.commerce().productName())
                .slug(faker.commerce().productName())
                .description(faker.commerce().material())
                .image(faker.internet().image())
                .price(faker.number().randomDouble(2, 1, 1000))
                .quantity(faker.number().numberBetween(1, 100))
                .status(faker.bool().bool())
                .subCategory(subCategory)
                .brand(brand)
                .unit(unit)
                .build();
    }
}
