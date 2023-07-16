package com.example.demo.behavorial.observer;

/**
 * Patrón observer:
 * Es útil cuando tenemos una asociación de tipo one to many entre clases y queremos que cuando se actualice el
 * objeto del lado "one" se notifique automáticamente a los objetos de lado "many"
 * Por ej. Un canal de youtube notificando nuevos videos subidos a sus subscriptores.
 */
public class Main {
    public static void main(String[] args) {

        // se crea la clase principal que cambia de estado y que los observadores tienen que seguir
        Weather test = new Weather();

        // se crean los observer y se agregan a la clase principal para que puedan ser notificados cuando haya
        // un cambio
        WeatherObserver computer = new Computer();
        test.addObserver(computer);

        test.addObserver(new SmartPhone());

        // cambio del tiempo
        // notifica automáticamente a los observer
        test.changeWeather(WeatherType.CLOUDY);
        test.changeWeather(WeatherType.RAINY);
        test.changeWeather(WeatherType.SUNNY);

        test.removeObserver(computer);
        test.changeWeather(WeatherType.SUNNY);
    }
}
