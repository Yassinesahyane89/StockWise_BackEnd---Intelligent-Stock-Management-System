package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.Impl;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.ResourceNotFoundException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Category;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.SubCategory;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.SubCategoryRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.CategoryService;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.SubCategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;
    private final CategoryService categoryService;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, CategoryService categoryService) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryService = categoryService;
    }
    @Override
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory getSubCategoryById(Long id) {
        return subCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id: " + id));
    }

    @Override
    public List<SubCategory> getSubCategoriesByCategoryId(Long categoryId) {
        // get category by id
        var category = categoryService.getCategoryById(categoryId);
        // create a list of subcategories
        List<SubCategory> subCategories = new ArrayList<>();
        // get subcategories by category
        if (category != null) {
            subCategories = subCategoryRepository.findByParentCategory(category);
        }

        // return the list of subcategories
        return subCategories;
    }

    @Override
    public SubCategory saveSubCategory(SubCategory subCategory) {
        // check the subCategory name
        if (subCategoryRepository.findBySubCategoryName(subCategory.getSubCategoryName()).isPresent()) {
            throw new ResourceNotFoundException("SubCategory with name: " + subCategory.getSubCategoryName() + " already exists");
        }

        // get category by id
        Long categoryId = subCategory.getParentCategory().getId();
        var category = categoryService.getCategoryById(categoryId);

        // Generate a unique subCategory code
        String generatedCode = generateUniqueSubCategoryCode(subCategory.getSubCategoryName());

        // set data
        subCategory.setSubCategoryCode(generatedCode);
        subCategory.setParentCategory(category);

        // save the subCategory
        return subCategoryRepository.save(subCategory);
    }

    // Generate a unique subCategory code
    private String generateUniqueSubCategoryCode(String subCategoryName) {
        // Remove spaces and convert to uppercase
        String baseCode = subCategoryName.replaceAll("\\s+", "").toUpperCase();
        String generatedCode = baseCode.substring(0, Math.min(baseCode.length(), 3)); // Take the first three characters

        // Check if the generated code already exists
        List<SubCategory> existingSubCategoriesWithCode = subCategoryRepository.findBySubCategoryCodeStartingWith(generatedCode);
        int counter = 1;
        while (isGeneratedCodeUnique(existingSubCategoriesWithCode, generatedCode)) {
            generatedCode = baseCode.substring(0, Math.min(baseCode.length(), 3)) + counter; // Append a counter if code already exists
            counter++;
        }

        return generatedCode;
    }

    // check if the generated code is unique
    private boolean isGeneratedCodeUnique(List<SubCategory> existingSubCategories, String generatedCode) {
        return existingSubCategories.stream()
                .anyMatch(cat -> cat.getSubCategoryCode().equals(generatedCode));
    }

    @Override
    public SubCategory updateSubCategory(Long id, SubCategory subCategory) {
        // get the subCategory by id
        var subCategoryToUpdate = this.getSubCategoryById(id);
        // check the subCategory name
        if (subCategoryRepository.findBySubCategoryName(subCategory.getSubCategoryName()).isPresent() && !subCategoryToUpdate.getSubCategoryName().equals(subCategory.getSubCategoryName())) {
            throw new ResourceNotFoundException("SubCategory with name: " + subCategory.getSubCategoryName() + " already exists");
        }

        // check if the name changed so generate a new code
        if (!subCategoryToUpdate.getSubCategoryName().equals(subCategory.getSubCategoryName())) {
            // Generate a unique subCategory code
            String generatedCode = generateUniqueSubCategoryCode(subCategory.getSubCategoryName());

            // set the generated code and update the subCategory
            subCategoryToUpdate.setSubCategoryCode(generatedCode);
        }

        // update the subCategory
        subCategoryToUpdate.setSubCategoryName(subCategory.getSubCategoryName());

        // set category
        Category category = categoryService.getCategoryById(subCategory.getParentCategory().getId());
        subCategoryToUpdate.setParentCategory(category);

        // set description
        subCategoryToUpdate.setDescription(subCategory.getDescription());

        // save the subCategory
        return subCategoryRepository.save(subCategoryToUpdate);
    }

    @Override
    public void deleteSubCategory(Long id) {
        // get the subCategory by id
        this.getSubCategoryById(id);

        // delete the subCategory
        subCategoryRepository.deleteById(id);
    }
}
