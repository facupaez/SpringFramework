package com.example.demo.behavorial.observer;

public class Computer implements WeatherObserver{
    @Override
    public void update(WeatherType type) {
        System.out.println("Computer has been notified of weather changed: " + type);
    }
}
