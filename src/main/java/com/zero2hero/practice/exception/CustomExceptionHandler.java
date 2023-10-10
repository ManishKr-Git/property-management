package com.zero2hero.practice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldErrors(MethodArgumentNotValidException manve){
        List<ErrorModel> errorModelList = new ArrayList<>();
        List<FieldError> fieldErrorList = manve.getBindingResult().getFieldErrors();
        for(FieldError fieldError:fieldErrorList){
            ErrorModel em = new ErrorModel();
            em.setCode(fieldError.getCode());
            em.setMessage(fieldError.getDefaultMessage());
            errorModelList.add(em);
        }
        return new ResponseEntity<>(errorModelList, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bEx){
        for (ErrorModel fieldError:bEx.getErrors()){
            LOGGER.debug("Business exception thrown in debug:{} - {}",fieldError.getCode(),fieldError.getMessage());
            LOGGER.info("Business exception thrown in info:{} - {}",fieldError.getCode(),fieldError.getMessage());
            LOGGER.warn("Business exception thrown in warn:{} - {}",fieldError.getCode(),fieldError.getMessage());
            LOGGER.error("Business exception thrown in error:{} - {}",fieldError.getCode(),fieldError.getMessage());
        }

        return new ResponseEntity<>(bEx.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
