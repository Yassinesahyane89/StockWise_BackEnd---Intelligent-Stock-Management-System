package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    Product updateProduct(Long id, Product product);

    Product getProductById(Long id);
    void deleteProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getAllProductsByStatus(Boolean status);
}
