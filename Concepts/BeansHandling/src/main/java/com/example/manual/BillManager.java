package com.example.manual;

public class BillManager {
    public CalculatorService calculatorService;

    public BillManager(CalculatorService calculatorService){
        System.out.println("Ejecutando constructor BillManager");
        this.calculatorService = calculatorService;
    }
}