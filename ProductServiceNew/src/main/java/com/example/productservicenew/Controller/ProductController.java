package com.example.productservicenew.Controller;

import com.example.productservicenew.DTO.ExceptionDTO;
import com.example.productservicenew.Models.Product;
import com.example.productservicenew.Service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    ProductController( //@Qualifier("selfProductService")
                      ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
//        throw new RuntimeException("Something went wrong");
//        ResponseEntity<Product> responseEntity=null;
//        Product product=null;
//        try {
//            product=productService.getProductById(id);
//            responseEntity=new ResponseEntity<>(product, HttpStatus.OK);
//        }
//        catch (RuntimeException exception){
//            ExceptionDTO exceptionDTO=new ExceptionDTO();
//            exceptionDTO.setMessage("Something went wrong");
//            ResponseEntity<ExceptionDTO> response=new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
//            return response;
//        }
//        return responseEntity;
        return productService.getProductById(id);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
