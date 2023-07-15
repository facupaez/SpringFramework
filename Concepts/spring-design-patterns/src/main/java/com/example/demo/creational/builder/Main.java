package com.example.demo.creational.builder;

import java.util.Calendar;

/**
 * Patron Builder:
 * Minimiza la creación de múltiples constructores cuando tenemos muchos atributos en una clase.
 * Permite construir objetos encadenando llamadas a métodos en una misma línea.
 */
public class Main {
    public static void main(String[] args) {

        User user1 = new User.Builder().setId(1L).build();

        User user2 = new User.Builder().setId(2L).setFirstName("Carlo").build();

        User user3 = new User.Builder().setId(3L).setFirstName("Frank").setLastName("Magno").build();

        User user4 = new User.Builder().setId(4L).setFirstName("Frank").setLastName("Magno").setEmail("cm@gmail.com").build();

        User user5 = new User.Builder().setId(5L).setFirstName("Frank").setLastName("Magno").setEmail("cm@gmail.com").setMarried(true).build();

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
        System.out.println(user5);
    }
}
