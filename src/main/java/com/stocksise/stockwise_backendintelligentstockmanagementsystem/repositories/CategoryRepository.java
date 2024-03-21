package com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // get category by name
    Optional<Category> findByName(String name);
}
