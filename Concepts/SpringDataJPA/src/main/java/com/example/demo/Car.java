package com.example.demo;

import jakarta.persistence.*;

/*
    Indicamos mediante la anotación @Entity que esta clase será una entidad.
 */
@Entity
public class Car {
    // atributos
    // Indicamos cual será el id y de tipo autoincrementable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String color;
    private Integer yearModel;

    // constructores
    public Car() {
    }

    public Car(String model, String color, Integer yearModel) {
        this.model = model;
        this.color = color;
        this.yearModel = yearModel;
    }

    // métodos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYearModel() {
        return yearModel;
    }

    public void setYearModel(Integer yearModel) {
        this.yearModel = yearModel;
    }

    // toString
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", yearModel=" + yearModel +
                '}';
    }
}
