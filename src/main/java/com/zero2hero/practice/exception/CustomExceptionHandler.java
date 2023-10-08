package com.zero2hero.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bEx){
        System.out.println("BusinessException is thrown");
        return new ResponseEntity<List<ErrorModel>>(bEx.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
