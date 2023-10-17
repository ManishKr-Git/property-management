package com.zero2hero.practice.controller;

import com.zero2hero.practice.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/calculator")
public class CalculatorController {

    @GetMapping("/add") //mapping variables using requestParam
    public Double add(@RequestParam("num1") Double num1,@RequestParam("num2") Double num2){
        return num1+num2;
    }

    @GetMapping("/sub/{num1}/{num2}")//mapping variables using pathVariables
    public Double substract(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2){
        Double result = null;
        if(num1>num2){
            result = num1-num2;
        }else{
            result = num2-num1;
        }
        return result;
    }

    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null;
        result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3();
        return  new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
