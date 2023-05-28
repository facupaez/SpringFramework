package com.example.componentScan;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {

    public CalculatorService(){
        System.out.println("Ejecutando constructor CalculatorService SCAN COMPONENT");
    }

    public String calculator() {
        return "Estoy en CalculatorService SCAN COMPONENT";
    }
}