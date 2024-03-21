package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.Impl;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.OperationException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.ResourceNotFoundException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Category;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.CategoryRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
    }

    @Override
    public Category saveCategory(Category category) {
        // check the category name
        if (categoryRepository.findByName(category.getName()).isPresent()) {
            throw new OperationException("Category with name: " + category.getName() + " already exists");
        }

        // generate the category slug
        category.setSlug(category.getName().toLowerCase().replace(" ", "-"));

        // save the category
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        // get the category by id
        Category categoryToUpdate = this.getCategoryById(id);

        // check the category name
        if (categoryRepository.findByName(category.getName()).isPresent() && !categoryToUpdate.getName().equals(category.getName())) {
            throw new OperationException("Category with name: " + category.getName() + " already exists");
        }

        // update the category
        categoryToUpdate.setName(category.getName());
        categoryToUpdate.setSlug(category.getName().toLowerCase().replace(" ", "-"));
        categoryToUpdate.setStatus(category.getStatus());

        // save the category
        return categoryRepository.save(categoryToUpdate);
    }

    @Override
    public void deleteCategory(Long id) {
        // get the category by id
        this.getCategoryById(id);

        // delete the category
        categoryRepository.deleteById(id);
    }
}
