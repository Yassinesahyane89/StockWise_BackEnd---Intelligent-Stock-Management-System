package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.seeders;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers.CategoryFaker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategorySeeder {
    private final CategoryFaker categoryFaker;
    private final CategoryRepository categoryRepository;

    public CategorySeeder(CategoryFaker categoryFaker, CategoryRepository categoryRepository) {
        this.categoryFaker = categoryFaker;
        this.categoryRepository = categoryRepository;
    }

    public void run() {
        categoryRepository.save(categoryFaker.create("Laptops", "laptops", true));
        categoryRepository.save(categoryFaker.create("Electronics", "electronics", true));
        categoryRepository.save(categoryFaker.create("Shoes", "shoes", true));
        categoryRepository.save(categoryFaker.create("Speakers", "speakers", true));
        categoryRepository.save(categoryFaker.create("Furniture", "furniture", true));
        categoryRepository.save(categoryFaker.create("Bags", "bags", true));
        categoryRepository.save(categoryFaker.create("Phones", "phones", true));
        categoryRepository.save(categoryFaker.create("Accessories", "accessories", true));
        categoryRepository.save(categoryFaker.create("Chairs", "chairs", true));
        categoryRepository.save(categoryFaker.create("Appliances", "appliances", true));
        categoryRepository.save(categoryFaker.create("Clothing", "clothing", true));
    }
}
