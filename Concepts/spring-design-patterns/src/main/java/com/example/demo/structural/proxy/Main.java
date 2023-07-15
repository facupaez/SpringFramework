package com.example.demo.structural.proxy;

/**
 * Patrón Proxy:
 * Se emplea principalmente en la carga de objetos pesados como SessionFactory, EntityManagerFactory.
 * Permite gestionar el ciclo de vida del objeto sin que el cliente tenga noción de ello.
 * El proxy funciona incluso aunque el objeto no haya sido inicializado o no este disponible.
 */
public class Main {
    public static void main(String[] args) {

        Image img = new ProxyImage("holamundo.jpg");

        // el proxy crea el objeto real por debajo la primera vez
        img.showImage();

        // el proxy ya tiene el objeto real cuando no lo crea de nuevo
        img.showImage();
    }
}
