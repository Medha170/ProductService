package com.example.productservicenew.Service;

import com.example.productservicenew.Controller.ProductController;
import com.example.productservicenew.Models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SelfProductServiceTest {
    @Autowired
    private ProductController productController;

    @Test
    void testValidProductId() {

        Product product = productController.getProductById(1L);
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void createProduct() {
    }
}