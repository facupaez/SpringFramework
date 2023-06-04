package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String operativeSystem;
    private String color;
    private Double inches;
    private Integer ROM;
    private Integer RAM;
    private String proccesor;
    private boolean touchScreen;

    public Laptop() {
    }

    public Laptop(Long id, String operativeSystem, String color, Double inches, Integer ROM, Integer RAM, String proccesor, boolean touchScreen) {
        this.id = id;
        this.operativeSystem = operativeSystem;
        this.color = color;
        this.inches = inches;
        this.ROM = ROM;
        this.RAM = RAM;
        this.proccesor = proccesor;
        this.touchScreen = touchScreen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperativeSystem() {
        return operativeSystem;
    }

    public void setOperativeSystem(String operativeSystem) {
        this.operativeSystem = operativeSystem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getInches() {
        return inches;
    }

    public void setInches(Double inches) {
        this.inches = inches;
    }

    public Integer getROM() {
        return ROM;
    }

    public void setROM(Integer ROM) {
        this.ROM = ROM;
    }

    public Integer getRAM() {
        return RAM;
    }

    public void setRAM(Integer RAM) {
        this.RAM = RAM;
    }

    public String getProccesor() {
        return proccesor;
    }

    public void setProccesor(String proccesor) {
        this.proccesor = proccesor;
    }

    public boolean isTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(boolean touchScreen) {
        this.touchScreen = touchScreen;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", operativeSystem='" + operativeSystem + '\'' +
                ", color='" + color + '\'' +
                ", inches=" + inches +
                ", ROM=" + ROM +
                ", RAM=" + RAM +
                ", proccesor='" + proccesor + '\'' +
                ", touchScreen=" + touchScreen +
                '}';
    }
}
