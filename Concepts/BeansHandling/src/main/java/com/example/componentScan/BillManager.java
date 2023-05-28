package com.example.componentScan;

import org.springframework.stereotype.Component;

@Component
public class BillManager {
    public CalculatorService calculatorService;

    public BillManager(CalculatorService calculatorService){
        System.out.println("Ejecutando constructor BillManager SCAN COMPONENT");
        this.calculatorService = calculatorService;
    }
}