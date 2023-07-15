package com.example.demo.behavorial.strategy;

/**
 * Patrón Strategy:
 * Permite utilizar algoritmos de forma dinámica.
 * Podemos cambiar un comportamiento en tiempo de ejecución como por ejemplo elegir un método de pago en un sistema.
 * Clara separación de comportamientos, cada algoritmo representa una estrategia.
 * Principios SOLID: principio Open Closed. Podemos introducir nuevas estrategias sin alterar el código original.
 *
 */
public class Main {
    public static void main(String[] args) {

        // preparar datos
        ShopCart cart = new ShopCart();

        Product product1 = new Product("12763187231ASDW", 9.99);
        Product product2 = new Product("12763187231BFFS", 19.99);

        cart.addProduct(product1);
        cart.addProduct(product2);

        // crear y ejecutar estrategia de pago
        cart.pay(new PayPalStrategy("", "", ""));

        // crear y ejecutar estrategia de pago
        cart.pay(new CreditCardStrategy("", "", "", ""));

        // podemos seguir agregando métodos de pagos
    }
}
