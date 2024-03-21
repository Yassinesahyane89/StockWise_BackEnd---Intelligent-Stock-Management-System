package com.stocksise.stockwise_backendintelligentstockmanagementsystem.web.RestController;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.response.ResponseMessage;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.SubCategoryRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.SubCategoryResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.SubCategory;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.SubCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sub-category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SubCategoryRestController {
    private final SubCategoryService subCategoryService;

    public SubCategoryRestController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    //get all sub categories
    @GetMapping("/all")
    public ResponseEntity<?> getAllSubCategories() {
        List<SubCategory> subCategories = subCategoryService.getAllSubCategories();
        if(subCategories.isEmpty()) {
            return ResponseMessage.notFound("No sub category found");
        }else {
            List<SubCategoryResponseDTO> subCategoryResponseDTOS = new ArrayList<>();
            for(SubCategory subCategory : subCategories) {
                subCategoryResponseDTOS.add(SubCategoryResponseDTO.fromSubCategory(subCategory));
            }
            return ResponseMessage.ok(subCategoryResponseDTOS, "Success");
        }
    }

    //get sub category by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getSubCategoryById(@PathVariable Long id) {
        // get the sub category by id
        SubCategory subCategory = subCategoryService.getSubCategoryById(id);

        // convert sub category to sub category response dto
        SubCategoryResponseDTO subCategoryResponseDTO = SubCategoryResponseDTO.fromSubCategory(subCategory);

        // return response
        return ResponseMessage.ok(subCategoryResponseDTO, "Success");
    }

    // get sub categories by category id
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getSubCategoriesByCategoryId(@PathVariable Long categoryId) {
        // get list of sub categories by category id
        List<SubCategory> subCategories = subCategoryService.getSubCategoriesByCategoryId(categoryId);

        // convert sub categories to sub category response dto
        List<SubCategoryResponseDTO> subCategoryResponseDTOS = new ArrayList<>();
        for(SubCategory subCategory : subCategories) {
            subCategoryResponseDTOS.add(SubCategoryResponseDTO.fromSubCategory(subCategory));
        }

        // return response
        return ResponseMessage.ok(subCategoryResponseDTOS, "Success");
    }

    // add sub category
    @PostMapping("/new-sub-category")
    public ResponseEntity<?> addSubCategory(@RequestBody SubCategoryRequestDTO subCategoryRequestDTO) {
        // convert sub category request dto to sub category
        SubCategory subCategory = SubCategoryRequestDTO.toSubCategory(subCategoryRequestDTO);

        // save the sub category
        subCategory= subCategoryService.saveSubCategory(subCategory);

        // convert sub category to sub category response dto
        SubCategoryResponseDTO subCategoryResponseDTO = SubCategoryResponseDTO.fromSubCategory(subCategory);

        // return response
        return ResponseMessage.created(subCategoryResponseDTO, "Sub Category added successfully");
    }

    // update sub category
    @PutMapping("/update-sub-category/{id}")
    public ResponseEntity<?> updateSubCategory(@RequestBody SubCategoryRequestDTO subCategoryRequestDTO, @PathVariable Long id) {
        // convert sub category request dto to sub category
        SubCategory subCategory = SubCategoryRequestDTO.toSubCategory(subCategoryRequestDTO);

        // update the sub category
        SubCategory updatedSubCategory = subCategoryService.updateSubCategory(id, subCategory);

        // convert sub category to sub category response dto
        SubCategoryResponseDTO subCategoryResponseDTO = SubCategoryResponseDTO.fromSubCategory(updatedSubCategory);

        // return response
        return ResponseMessage.ok(subCategoryResponseDTO, "Sub Category updated successfully");
    }

    // delete sub category
    @DeleteMapping("/delete-sub-category/{id}")
    public ResponseEntity<?> deleteSubCategory(@PathVariable Long id) {
        // delete the sub category
        subCategoryService.deleteSubCategory(id);

        // return response
        return ResponseMessage.ok(null,"Sub Category deleted successfully");
    }
}
