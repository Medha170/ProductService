package com.example.productservicenew.Service;

import com.example.productservicenew.DTO.FakeStoreProductDTO;
import com.example.productservicenew.Exceptions.ProductNotFoundException;
import com.example.productservicenew.Models.Category;
import com.example.productservicenew.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements  ProductService{
    private Product convertToProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product product=new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setImageUrl(fakeStoreProductDTO.getImageUrl());
        product.setCategory(new Category());
        Category category = new Category();
        category.setDescription(fakeStoreProductDTO.getCategory());
        product.setCategory(category);

        return product;
    }
    @Override
    public Product getProductById(Long id) {
//        throw new RuntimeException("Something went wrong in Service");
//        int var=1/0;
        RestTemplate restTemplate=new RestTemplate();
        FakeStoreProductDTO fakeStoreProductDTO=restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                FakeStoreProductDTO.class);
        if (fakeStoreProductDTO==null) throw new ProductNotFoundException(id, "Please pass a valid productID");
        return convertToProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate=new RestTemplate();
        FakeStoreProductDTO[] fakeStoreProductDTOS=restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class
        );
        List<Product> list=new ArrayList<>();
        if (fakeStoreProductDTOS==null) return null;
        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS){
            list.add(convertToProduct(fakeStoreProductDTO));
        }
        return list;
    }
}
