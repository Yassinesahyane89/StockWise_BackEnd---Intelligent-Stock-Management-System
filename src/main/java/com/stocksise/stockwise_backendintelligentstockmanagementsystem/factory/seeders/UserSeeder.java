package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.seeders;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers.UserFaker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.RoleRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder {
    private final UserFaker userFaker;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserSeeder(UserFaker userFaker, UserRepository userRepository, RoleRepository roleRepository) {
        this.userFaker = userFaker;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void run(Integer count) {
        // get all roles
        var roles = roleRepository.findAll();

        // create users
        for (int i = 0; i < count; i++) {
            // get a random role
            var role = roles.get((int) (Math.random() * roles.size()));
            userRepository.save(userFaker.create(role));
        }
    }
}
