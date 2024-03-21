package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.seeders;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers.UnitFaker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.UnitRepository;
import org.springframework.stereotype.Component;

@Component
public class UnitSeeder {
    private final UnitFaker unitFaker;
    private final UnitRepository unitRepository;

    public UnitSeeder(UnitFaker unitFaker, UnitRepository unitRepository) {
        this.unitFaker = unitFaker;
        this.unitRepository = unitRepository;
    }

    public void run() {
        unitRepository.save(unitFaker.create("Kilogram", "kg"));
        unitRepository.save(unitFaker.create("Gram", "g"));
        unitRepository.save(unitFaker.create("Liter", "L"));
        unitRepository.save(unitFaker.create("Milliliter", "mL"));
        unitRepository.save(unitFaker.create("Piece", "Pcs"));
        unitRepository.save(unitFaker.create("Dozen", "Dz"));
        unitRepository.save(unitFaker.create("Box", "Box"));
        unitRepository.save(unitFaker.create("Carton", "Ctn"));
    }
}
