package com.example.demo.behavorial.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase weather notifica el cambio de tiempo a los observers
 */
public class Weather {
    private WeatherType currentWeather;
    // One(Weather) to Many(Observers)
    private List<WeatherObserver> observerList;

    public Weather(){
        this.observerList = new ArrayList<>();
    }

    public void addObserver(WeatherObserver observer){
        System.out.println("Agregando observer");
        this.observerList.add(observer);
    }

    public void removeObserver(WeatherObserver observer){
        System.out.println("Eliminando observer");
        this.observerList.remove(observer);
    }

    // notifica el cambio de tiempo a los observers
    void changeWeather(WeatherType currentWeather){
        this.currentWeather = currentWeather;
        this.notifyObservers();
    }

    // modifica los observers
    private void notifyObservers() {
        for (WeatherObserver observer:this.observerList){
            observer.update(this.currentWeather);
        }
    }
}
