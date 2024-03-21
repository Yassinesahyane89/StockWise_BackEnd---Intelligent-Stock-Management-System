package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers;

import com.github.javafaker.Faker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Unit;
import org.springframework.stereotype.Component;

@Component
public class UnitFaker {
    private final Faker faker;

    public UnitFaker() {
        this.faker = new Faker();
    }

    public Unit create(String unitName, String shortName) {
        return Unit.builder()
                .name(unitName)
                .shortName(shortName)
                .status(faker.bool().bool())
                .build();
    }
}
