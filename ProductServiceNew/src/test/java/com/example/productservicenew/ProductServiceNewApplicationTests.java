package com.example.productservicenew;

import com.example.productservicenew.Models.Category;
import com.example.productservicenew.Models.Product;
import com.example.productservicenew.Repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ProductServiceNewApplicationTests {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }
//    @Test
//    void testEagerVsLazyFetch(){
//        Optional<Category> optionalCategory = categoryRepository.findById(1L);
//        Category category = optionalCategory.get();
//        System.out.println("Fetching the list of products for the above category");
////        List<Product> products = category.getProducts();
////        System.out.println(products.get(0).getTitle());
//        System.out.println("DEBUG");
//    }

    @Test
    void sampleTestCase(){

    }
    @Test
    void testOnePlusOneEqualsTwo(){
        int i = 1 + 1;
//        assert i == 3;
        assertEquals(2, i, "i's value isn't 2, that's why this testcase didn't pass");

//        assertThrows(RuntimeException.class, fun(100));
    }
}
