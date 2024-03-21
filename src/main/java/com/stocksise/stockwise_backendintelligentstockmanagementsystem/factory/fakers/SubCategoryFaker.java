package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers;

import com.github.javafaker.Faker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Category;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.SubCategory;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryFaker {
    private final Faker faker;

    public SubCategoryFaker() {
        this.faker = new Faker();
    }

    public SubCategory create(String subCategoryName, String subCategoryCode, String description, Category category) {
        return SubCategory.builder()
                .subCategoryName(subCategoryName)
                .subCategoryCode(subCategoryCode)
                .description(description)
                .parentCategory(category)
                .build();
    }
}
