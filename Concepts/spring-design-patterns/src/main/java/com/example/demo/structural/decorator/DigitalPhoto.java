package com.example.demo.structural.decorator;

public class DigitalPhoto extends Photo{
    @Override
    public String show() {
        return "Normal photo without edit";
    }

    @Override
    public double cost() {
        return 15;
    }
}
