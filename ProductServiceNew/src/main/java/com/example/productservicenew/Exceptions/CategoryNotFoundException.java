package com.example.productservicenew.Exceptions;

public class CategoryNotFoundException extends RuntimeException{
//    private Long id;
    public CategoryNotFoundException(String message){
        super(message);
    }
}
