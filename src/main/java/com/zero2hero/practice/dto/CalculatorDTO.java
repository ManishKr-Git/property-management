package com.zero2hero.practice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculatorDTO {
    private Double num1;
    private Double num2;
    @JsonProperty("num31")
    private Double num3;

    public Double getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public Double getNum3() {
        return num3;
    }

    public void setNum3(Double num3) {
        this.num3 = num3;
    }
}
