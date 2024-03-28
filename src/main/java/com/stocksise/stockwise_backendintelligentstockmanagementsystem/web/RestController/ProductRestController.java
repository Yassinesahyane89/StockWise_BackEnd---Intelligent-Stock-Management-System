package com.stocksise.stockwise_backendintelligentstockmanagementsystem.web.RestController;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.response.ResponseMessage;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.ProductRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.ProductResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Product;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    //get all products
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        if(products.isEmpty()) {
            return ResponseMessage.notFound("No product found");
        }else {
            List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
            for(Product product : products) {
                productResponseDTOS.add(ProductResponseDTO.fromProduct(product));
            }
            return ResponseMessage.ok(productResponseDTOS, "Success");
        }
    }

    //get product by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        // get the product by id
        Product product = productService.getProductById(id);

        // convert product to product response dto
        ProductResponseDTO productResponseDTO = ProductResponseDTO.fromProduct(product);

        // return response
        return ResponseMessage.ok(productResponseDTO, "Success");
    }

    // add product
    @PostMapping("/new-product")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        // convert product request dto to product
        Product product = ProductRequestDTO.toProduct(productRequestDTO);

        // save the product
        product=productService.saveProduct(product);

        // convert product to product response dto
        ProductResponseDTO productResponseDTO = ProductResponseDTO.fromProduct(product);

        // return response
        return ResponseMessage.created(productResponseDTO, "Product added successfully");
    }

    // update product
    @PutMapping("/update-product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductRequestDTO productRequestDTO, @PathVariable Long id) {
        // convert product request dto to product
        Product product = ProductRequestDTO.toProduct(productRequestDTO);

        // update the product
        Product updatedProduct = productService.updateProduct(id, product);

        // convert product to product response dto
        ProductResponseDTO productResponseDTO = ProductResponseDTO.fromProduct(updatedProduct);

        // return response
        return ResponseMessage.ok(productResponseDTO, "Product updated successfully");
    }

    // delete product
    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        // delete the product
        productService.deleteProductById(id);

        // return response
        return ResponseMessage.ok(null,"Product deleted successfully");
    }

    @GetMapping
    public ResponseEntity<?> ProductCategory(){

        return ResponseMessage.ok(productService.getcatgeroWithAllProduct(), "Success");
    }
}
