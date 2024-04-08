package com.example.productservicenew.ExceptionHandlers;

import com.example.productservicenew.DTO.ExceptionDTO;
import com.example.productservicenew.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDTO> handleArithmeticException(){
        ExceptionDTO dto=new ExceptionDTO();
        dto.setMessage("Something went wrong");
        dto.setResolution("ArithmeticException");
        ResponseEntity<ExceptionDTO> response=new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDTO dto=new ExceptionDTO();
        dto.setMessage("Invalid ID "+productNotFoundException.getId()+" passed");
        dto.setResolution("ProductNotFoundException Caught");
        ResponseEntity<ExceptionDTO> response=new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleException(){
        ExceptionDTO dto=new ExceptionDTO();
        dto.setMessage("Something went wrong");
        dto.setResolution("Exception");
        ResponseEntity<ExceptionDTO> response=new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

}
