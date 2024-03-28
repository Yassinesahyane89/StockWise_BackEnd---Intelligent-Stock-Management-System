package com.stocksise.stockwise_backendintelligentstockmanagementsystem;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.config.RsaKeyConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({RsaKeyConfigProperties.class})
public class StockWiseBackEndIntelligentStockManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockWiseBackEndIntelligentStockManagementSystemApplication.class, args);
    }

}
