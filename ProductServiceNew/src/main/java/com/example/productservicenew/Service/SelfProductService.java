package com.example.productservicenew.Service;

import com.example.productservicenew.Exceptions.CategoryNotFoundException;
import com.example.productservicenew.Exceptions.ProductNotFoundException;
import com.example.productservicenew.Models.Category;
import com.example.productservicenew.Models.Product;
import com.example.productservicenew.Repositories.CategoryRepository;
import com.example.productservicenew.Repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements  ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()){
            throw new ProductNotFoundException(id, "Product Not Found!");
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if (category.getId() == null){
            product.setCategory(categoryRepository.save(category));
        }

        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

        if (optionalCategory.isEmpty()){
            throw new CategoryNotFoundException("Invalid Category id passed.");
        }

        product1.setCategory(optionalCategory.get());
        return product1;
    }
}
