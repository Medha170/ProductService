package com.example.productservicenew.Exceptions;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends RuntimeException{
    private  Long id;
    public ProductNotFoundException(Long id,String message){
        super(message);
        this.id=id;
    }
}
