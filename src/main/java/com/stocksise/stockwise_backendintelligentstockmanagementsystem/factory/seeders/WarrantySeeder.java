package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.seeders;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers.WarrantyFaker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.PeriodsType;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.WarrantyRepository;
import org.springframework.stereotype.Component;

@Component
public class WarrantySeeder {
    private final WarrantyFaker warrantyFaker;
    private final WarrantyRepository warrantyRepository;

    public WarrantySeeder(WarrantyFaker warrantyFaker, WarrantyRepository warrantyRepository) {
        this.warrantyFaker = warrantyFaker;
        this.warrantyRepository = warrantyRepository;
    }

    public void run(){
        warrantyRepository.save(warrantyFaker.create(
                "Express Warranty",
                "Repairs or a replacement for a faulty product within a specified time period after it was purchased",
                3L,
                PeriodsType.MONTH,
                true
        ));
        warrantyRepository.save(warrantyFaker.create(
                "Special warranty	",
                "Seller of the property(grantor) warrants only against anything that occurred during their physical ownership",
                6L,
                PeriodsType.MONTH,
                true
        ));
        warrantyRepository.save(warrantyFaker.create(
                "Implied Warranty",
                "A warranty that is not written or expressed but is implied by law",
                1L,
                PeriodsType.YEAR,
                true
        ));
    }
}
