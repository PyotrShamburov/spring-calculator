package by.home.entity;

import javax.validation.constraints.*;

public class Operation {

    //@Pattern(regexp = "^(\\d+\\.\\d+)|(\\d+)$",  message = "Number must consists from digits only!")
    private double num1;

    //@Pattern(regexp = "^(\\d+\\.\\d+)|(\\d+)$", message = "Number must consists from digits only!")
    private double num2;

    @NotBlank
    @Pattern(regexp = "^([a-z]{3})$",  message = "Only characters put here!")
    private String operator;
    private String result;

    public Operation() {
    }

    public Operation(double num1, double num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
