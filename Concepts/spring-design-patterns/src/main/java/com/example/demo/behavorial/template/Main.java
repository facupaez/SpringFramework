package com.example.demo.behavorial.template;

/**
 * Patrón template:
 * Tenemos una clase abstracta con una seria de métodos abstractos.
 * El objetivo principal es llevar a cabo una acción reutilizando todas las partes comunes que existan desacoplando y reutilizando código.
 */
public class Main {

    public static void main(String[] args) {

        HtmlHome home = new HtmlHome();
        System.out.println(home.render());

        HtmlContactUs contactUs = new HtmlContactUs();
        System.out.println(contactUs.render());

    }
}
