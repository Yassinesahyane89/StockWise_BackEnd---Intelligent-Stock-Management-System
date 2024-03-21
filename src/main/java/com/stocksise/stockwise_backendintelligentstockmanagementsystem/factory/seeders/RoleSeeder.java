package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.seeders;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers.RoleFaker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder {
    private final RoleFaker roleFaker;
    private final RoleRepository roleRepository;

    public RoleSeeder(RoleFaker roleFaker, RoleRepository roleRepository) {
        this.roleFaker = roleFaker;
        this.roleRepository = roleRepository;
    }

    public void run() {

        //create roles
        roleRepository.save(roleFaker.create("ADMIN"));
        roleRepository.save(roleFaker.create("USER"));
        roleRepository.save(roleFaker.create("MANAGER"));
    }
}
