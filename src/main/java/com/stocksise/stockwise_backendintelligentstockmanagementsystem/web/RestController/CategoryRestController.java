package com.stocksise.stockwise_backendintelligentstockmanagementsystem.web.RestController;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.response.ResponseMessage;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.CategoryRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.CategoryResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Category;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryRestController {
    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //get all categories
    @GetMapping("/all")
    public ResponseEntity<?> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        if(categories.isEmpty()) {
            return ResponseMessage.notFound("No category found");
        }else {
            List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();
            for(Category category : categories) {
                categoryResponseDTOS.add(CategoryResponseDTO.fromCategory(category));
            }
            return ResponseMessage.ok(categoryResponseDTOS, "Success");
        }
    }

    //get category by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        // get the category by id
        Category category = categoryService.getCategoryById(id);

        // convert category to category response dto
        CategoryResponseDTO categoryResponseDTO = CategoryResponseDTO.fromCategory(category);

        // return response
        return ResponseMessage.ok(categoryResponseDTO, "Success");
    }

    // get category by name
    @GetMapping("/name/{name}")
    public ResponseEntity<?> getCategoryByName(@PathVariable String name) {
        // get the category by name
        Category category = categoryService.getCategoryByName(name);

        // convert category to category response dto
        CategoryResponseDTO categoryResponseDTO = CategoryResponseDTO.fromCategory(category);

        // return response
        return ResponseMessage.ok(categoryResponseDTO, "Success");
    }

    // add category
    @PostMapping("/new-category")
    public ResponseEntity<?> addCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        // convert category request dto to category
        Category category = CategoryRequestDTO.toCategory(categoryRequestDTO);

        // save the category
        category=categoryService.saveCategory(category);

        // convert category to category response dto
        CategoryResponseDTO categoryResponseDTO = CategoryResponseDTO.fromCategory(category);

        // return response
        return ResponseMessage.created(categoryResponseDTO, "Category added successfully");
    }

    // update category
    @PutMapping("/update-category/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryRequestDTO categoryRequestDTO, @PathVariable Long id) {
        // convert category request dto to category
        Category category = CategoryRequestDTO.toCategory(categoryRequestDTO);

        // update the category
        Category updatedCategory = categoryService.updateCategory(id, category);

        // convert category to category response dto
        CategoryResponseDTO categoryResponseDTO = CategoryResponseDTO.fromCategory(updatedCategory);

        // return response
        return ResponseMessage.ok(categoryResponseDTO, "Category updated successfully");
    }

    // delete category
    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        // delete the category
        categoryService.deleteCategory(id);

        // return response
        return ResponseMessage.ok(null,"Category deleted successfully");
    }
}
