package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.Impl;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.OperationException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Category;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category;
    @BeforeEach
    void setUp() {
        category = Category.builder()
                .name("Electronics")
                .slug("electronics")
                .status(true)
                .build();
    }

    @DisplayName("Save Category in name should throw exception")
    @Test
    void saveCategory_saveCategoryInvalidName_shouldThrowException() {
        Category invalidNameCategory = Category.builder()
                .name(category.getName())
                .build();

        when(categoryRepository.findByName(invalidNameCategory.getName())).thenReturn(java.util.Optional.of(category));

        OperationException exception = assertThrows(OperationException.class, () -> categoryService.saveCategory(invalidNameCategory));
        assertEquals("Category with name: " + invalidNameCategory.getName() + " already exists", exception.getMessage());
    }

    @DisplayName("Save Category should pass with no exception")
    @Test
    void saveCategory_saveCategoryValid_shouldPass() throws OperationException {
        Category validCategory = Category.builder()
                .name("Electronics")
                .slug("electronics")
                .status(true)
                .build();

        when(categoryRepository.findByName(validCategory.getName())).thenReturn(java.util.Optional.empty());
        when(categoryRepository.save(validCategory)).thenReturn(validCategory);
        Category savedCategory = categoryService.saveCategory(validCategory);
        assertEquals(validCategory, savedCategory);
    }

    @DisplayName("Update Category should pass with no exception")
    @Test
    void updateCategory_updateCategoryValid_shouldPass() throws OperationException {
        Category validCategory = Category.builder()
                .name("Electronics")
                .slug("electronics")
                .status(true)
                .build();

        when(categoryRepository.findByName(validCategory.getName())).thenReturn(java.util.Optional.empty());
        when(categoryRepository.findById(1L)).thenReturn(java.util.Optional.of(category));
        when(categoryRepository.save(category)).thenReturn(category);
        Category updatedCategory = categoryService.updateCategory(1L, validCategory);
        assertEquals(validCategory, updatedCategory);
    }
}