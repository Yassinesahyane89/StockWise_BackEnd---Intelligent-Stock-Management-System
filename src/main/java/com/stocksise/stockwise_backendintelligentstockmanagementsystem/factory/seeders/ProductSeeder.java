package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.seeders;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers.ProductFaker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.*;
import org.springframework.stereotype.Component;

@Component
public class ProductSeeder {
    private final ProductFaker productFaker;
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final UnitRepository unitRepository;

    public ProductSeeder(ProductFaker productFaker, ProductRepository productRepository, BrandRepository brandRepository, SubCategoryRepository subCategoryRepository, UnitRepository unitRepository) {
        this.productFaker = productFaker;
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.unitRepository = unitRepository;
    }

    public void run(Integer count) {
        // get all brands
         var brands = brandRepository.findAll();
        // get all sub categories
        var subCategories = subCategoryRepository.findAll();
        // get all units
        var units = unitRepository.findAll();
        for (int i = 0; i < count; i++) {
            // set random brand
            var brand = brands.get((int) (Math.random() * brands.size()));

            // set random subCategory
            var subCategory = subCategories.get((int) (Math.random() * subCategories.size()));
            
            // set random unit
            var unit = units.get((int) (Math.random() * units.size()));

            // set random product
            productRepository.save(productFaker.create(brand, subCategory, unit));
        }
    }
}
