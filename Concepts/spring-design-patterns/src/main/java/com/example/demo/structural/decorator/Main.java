package com.example.demo.structural.decorator;

import com.example.demo.structural.decorator.decorators.RetroEffect;
import com.example.demo.structural.decorator.decorators.VintageEffect;

/**
 * Patrón Decorator:
 * Permite agregar nuevas funcionalidades a objetos existentes o decorar objetos decorados previamente con
 * nuevas funcionalidades.
 */
public class Main {
    public static void main(String[] args) {
        // creamos foto original
        Photo photo = new DigitalPhoto();
        System.out.println(photo.show());

        // aplicamos decorador a la foto original
        Photo photoRetro = new RetroEffect(photo);
        System.out.println(photoRetro.show());

        Photo photoVintage = new VintageEffect(photo);
        System.out.println(photoVintage.show());

        // aplicamos doble decorador a la foto original
        Photo photoRetroVintage = new RetroEffect(new VintageEffect(photo));
        System.out.println(photoRetroVintage.show());

        System.out.println("Fin de decoradores");
    }
}
