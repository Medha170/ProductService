package com.example.productservicenew.Controller;

import com.example.productservicenew.Models.Product;
import com.example.productservicenew.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void testValidProductId() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("iphone 15");
        product.setDescription("Latest iphone");
//        product.setCategory();
        when(productService.getProductById(1L))
                .thenReturn(product);

        Product outputProduct = productController.getProductById(1L);
        assertEquals(product, outputProduct);
    }

    @Test
    void getProductById() {
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void createProduct() {
    }
}