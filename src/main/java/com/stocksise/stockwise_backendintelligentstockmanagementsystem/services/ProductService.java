package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Category;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Product;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.SubCategory;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Product saveProduct(Product product);

    Product updateProduct(Long id, Product product);

    Product getProductById(Long id);
    void deleteProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getAllProductsByStatus(Boolean status);

    List<Map<String, Long>> getcatgeroWithAllProduct();
}
