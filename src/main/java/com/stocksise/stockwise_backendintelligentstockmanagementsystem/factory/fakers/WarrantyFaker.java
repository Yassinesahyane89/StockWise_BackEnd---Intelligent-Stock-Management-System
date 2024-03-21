package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers;

import com.github.javafaker.Faker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Warranty;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.PeriodsType;
import org.springframework.stereotype.Component;

@Component
public class WarrantyFaker {
    private final Faker faker;

    public WarrantyFaker() {
        this.faker = new Faker();
    }

    public Warranty create(String name, String description, Long duration, PeriodsType periodsType, Boolean status) {
        return Warranty.builder()
                .name(name)
                .description(description)
                .duration(duration)
                .period(periodsType)
                .status(status)
                .build();
    }
}
