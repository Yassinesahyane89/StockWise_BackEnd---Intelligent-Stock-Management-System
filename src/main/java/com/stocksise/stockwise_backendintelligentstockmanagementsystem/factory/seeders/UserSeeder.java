package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.seeders;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers.UserFaker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder {
    private final UserFaker userFaker;
    private final UserRepository userRepository;

    public UserSeeder(UserFaker userFaker, UserRepository userRepository) {
        this.userFaker = userFaker;
        this.userRepository = userRepository;
    }

    public void run(Integer count) {
        for (int i = 0; i < count; i++) {
            userRepository.save(userFaker.create());
        }
    }
}
