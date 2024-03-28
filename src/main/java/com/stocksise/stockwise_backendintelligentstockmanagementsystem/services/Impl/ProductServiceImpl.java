package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.Impl;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.ResourceNotFoundException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.*;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.ProductRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.BrandService;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.ProductService;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.SubCategoryService;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.UnitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final SubCategoryService subCategoryService;
    private final BrandService brandService;
    private final UnitService unitService;

    public ProductServiceImpl(ProductRepository productRepository, SubCategoryService subCategoryService, BrandService brandService, UnitService unitService) {
        this.productRepository = productRepository;
        this.subCategoryService = subCategoryService;
        this.brandService = brandService;
        this.unitService = unitService;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Product with id " + id + " not found")
                );
    }

    // Method to generate a SKU for a product
    public String generateSku() {
        // Generate a unique identifier using UUID
        String uuid = UUID.randomUUID().toString();
        // Extract the first 8 characters to use as the SKU
        String sku = uuid.substring(0, 8);

        // return the SKU
        return sku;
    }

    @Override
    public Product saveProduct(Product product) {
        // check the product name
        if (productRepository.findByName(product.getName()).isPresent()) {
            throw new ResourceNotFoundException("Product with name " + product.getName() + " already exists");
        }

        // get category
        SubCategory subCategory = subCategoryService.getSubCategoryById(product.getSubCategory().getId());

        // get brand
        Brand brand = brandService.getBrandById(product.getBrand().getId());

        // get unit
        Unit unit = unitService.getUnitById(product.getUnit().getId());

        // generate sku
        String sku = this.generateSku();

        // generate slug
        String slug = product.getName().toLowerCase().replace(" ", "-");


        // set sku, slug, category, brand
        product.setSku(sku);
        product.setSlug(slug);
        product.setSubCategory(subCategory);
        product.setBrand(brand);
        product.setUnit(unit);

        // save product
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        // check the product name
        if (productRepository.findByName(product.getName()).isPresent() && !productRepository.findByName(product.getName()).get().getId().equals(id)) {
            throw new ResourceNotFoundException("Product with name " + product.getName() + " already exists");
        }

        // get product by id
        Product productToUpdate = this.getProductById(id);

        // get category
        SubCategory subCategory = subCategoryService.getSubCategoryById(product.getSubCategory().getId());

        // get brand
        Brand brand = brandService.getBrandById(product.getBrand().getId());

        // get unit
        Unit unit = unitService.getUnitById(product.getUnit().getId());

        // generate slug
        if(product.getName() != productToUpdate.getName()) {
            String slug = product.getName().toLowerCase().replace(" ", "-");
            product.setSlug(slug);
        }

        // set sku, slug, category, brand
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setQuantity(product.getQuantity());
        productToUpdate.setSubCategory(subCategory);
        productToUpdate.setBrand(brand);
        productToUpdate.setUnit(unit);
        productToUpdate.setStatus(product.getStatus());

        // save product
        return productRepository.save(productToUpdate);
    }

    @Override
    public void deleteProductById(Long id) {
        // get product by id
        Product product = this.getProductById(id);

        // delete product
        productRepository.delete(product);
    }

    @Override
    public List<Product> getAllProductsByStatus(Boolean status) {
        return productRepository.findAllByStatus(status);
    }

    @Override
    public List<Map<String, Long>> getcatgeroWithAllProduct() {
        List<SubCategory> categories = subCategoryService.getAllSubCategories();
        List<Product> products = productRepository.findAll();
        return null;
    }
}
