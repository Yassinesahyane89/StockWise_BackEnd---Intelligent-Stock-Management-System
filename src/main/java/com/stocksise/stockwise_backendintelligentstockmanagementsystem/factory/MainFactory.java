package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.seeders.UserSeeder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainFactory implements CommandLineRunner {
    private final UserSeeder userSeeder;

    public MainFactory(UserSeeder userSeeder) {
        this.userSeeder = userSeeder;
    }

    @Value("${seed.enabled}")
    public Boolean isSeedEnabled;
    @Override
    public void run(String... args) throws Exception {
        if(Boolean.FALSE.equals(isSeedEnabled)) return;
        userSeeder.run(10);
    }
}
