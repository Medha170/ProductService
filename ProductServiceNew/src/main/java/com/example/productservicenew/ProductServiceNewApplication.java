package com.example.productservicenew;

import com.example.productservicenew.Models.Category;
import com.example.productservicenew.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class ProductServiceNewApplication {


    public static void main(String[] args) {

        SpringApplication.run(ProductServiceNewApplication.class, args);
    }

}
