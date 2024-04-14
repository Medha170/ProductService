package com.example.productservicenew.Service;

import com.example.productservicenew.Models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
}
