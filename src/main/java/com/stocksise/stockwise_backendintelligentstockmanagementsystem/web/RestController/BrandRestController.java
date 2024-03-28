package com.stocksise.stockwise_backendintelligentstockmanagementsystem.web.RestController;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.response.ResponseMessage;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.BrandRequest;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.BrandResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Brand;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/brand")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BrandRestController {
    private final BrandService brandService;

    public BrandRestController(BrandService brandService) {
        this.brandService = brandService;
    }

    //get all brands
    @GetMapping("/all")
    public ResponseEntity<?> getAllBrands() {
        List<Brand> brands = brandService.getAllBrands();
        if(brands.isEmpty()) {
            return ResponseMessage.notFound("No brand found");
        }else {
            List<BrandResponseDTO> brandResponseDTOS = new ArrayList<>();
            for(Brand brand : brands) {
                brandResponseDTOS.add(BrandResponseDTO.fromBrand(brand));
            }
            return ResponseMessage.ok(brandResponseDTOS, "Success");
        }
    }

    //get brand by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getBrandById(@PathVariable Long id) {
        // get the brand by id
        Brand brand = brandService.getBrandById(id);

        // convert brand to brand response dto
        BrandResponseDTO brandResponseDTO = BrandResponseDTO.fromBrand(brand);

        // return response
        return ResponseMessage.ok(brandResponseDTO, "Success");
    }

    // add brand
    @PostMapping("/new-brand")
    public ResponseEntity<?> addBrand(@RequestBody BrandRequest brandRequest) {
        // convert brand request dto to brand
        Brand brand = BrandRequest.toBrand(brandRequest);

        // save the brand
        brand = brandService.saveBrand(brand);

        // convert brand to brand response dto
        BrandResponseDTO brandResponseDTO = BrandResponseDTO.fromBrand(brand);

        // return response
        return ResponseMessage.created(brandResponseDTO, "Brand added successfully");
    }

    // update brand
    @PutMapping("/update-brand/{id}")
    public ResponseEntity<?> updateBrand(@RequestBody BrandRequest brandRequest, @PathVariable Long id) {
        // convert brand request dto to brand
        Brand brand = BrandRequest.toBrand(brandRequest);

        // update the brand
        Brand updatedBrand = brandService.updateBrand(id, brand);

        // convert brand to brand response dto
        BrandResponseDTO brandResponseDTO = BrandResponseDTO.fromBrand(updatedBrand);

        // return response
        return ResponseMessage.ok(brandResponseDTO, "Brand updated successfully");
    }

    // filter brands by status
    @GetMapping("/filter-by-status/{status}")
    public ResponseEntity<?> filterBrandsByStatus(@PathVariable String status) {
        // get the brands by status
        List<Brand> brands = brandService.filterBrandsByStatus(status);

        // convert brands to brand response dto
        List<BrandResponseDTO> brandResponseDTOS = new ArrayList<>();
        for(Brand brand : brands) {
            brandResponseDTOS.add(BrandResponseDTO.fromBrand(brand));
        }

        // return response
        return ResponseMessage.ok(brandResponseDTOS, "Success");
    }

    // delete brand
    @DeleteMapping("/delete-brand/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        // delete the brand
        brandService.deleteBrand(id);

        // return response
        return ResponseMessage.ok(null,"Brand deleted successfully");
    }
}
