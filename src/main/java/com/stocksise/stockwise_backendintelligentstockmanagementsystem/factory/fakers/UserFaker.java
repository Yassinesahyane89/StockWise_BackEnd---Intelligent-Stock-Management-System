package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers;

import com.github.javafaker.Faker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.User;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.userStatus;
import org.springframework.stereotype.Component;

@Component
public class UserFaker {
    private final Faker faker;

    public UserFaker() {
        this.faker = new Faker();
    }

    public User create() {
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .status(faker.options().option(userStatus.values()))
                .build();
    }
}
