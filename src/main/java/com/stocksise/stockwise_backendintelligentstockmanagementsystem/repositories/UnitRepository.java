package com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    // find by name
    Optional<Unit> findByName(String name);

    Optional<Object> findByShortName(String shortName);
}
