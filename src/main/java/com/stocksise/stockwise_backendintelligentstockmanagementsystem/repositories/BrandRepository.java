package com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    // find brand by name
    Optional<Brand> findByName(String name);

    // find brand by email
    Optional<Brand> findByEmail(String email);

    List<Brand> findByStatus(boolean status);
}
