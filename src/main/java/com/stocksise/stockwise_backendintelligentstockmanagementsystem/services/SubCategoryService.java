package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.SubCategory;

import java.util.List;

public interface SubCategoryService {
    List<SubCategory> getAllSubCategories();
    SubCategory getSubCategoryById(Long id);

    // get list of subcategories by category id
    List<SubCategory> getSubCategoriesByCategoryId(Long categoryId);
    SubCategory saveSubCategory(SubCategory subCategory);
    SubCategory updateSubCategory(Long id, SubCategory subCategory);
    void deleteSubCategory(Long id);
}
