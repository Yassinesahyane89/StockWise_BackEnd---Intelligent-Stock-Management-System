package com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Category;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    // find subCategory by name
    Optional<SubCategory> findBySubCategoryName(String name);

    // find subCategory by code
    List<SubCategory> findBySubCategoryCodeStartingWith(String code);

    // find subCategory by parent category
    List<SubCategory> findByParentCategory(Category category);
}
