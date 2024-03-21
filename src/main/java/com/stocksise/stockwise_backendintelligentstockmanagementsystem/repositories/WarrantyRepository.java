package com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {
    Optional<Object> findByName(String name);
}
