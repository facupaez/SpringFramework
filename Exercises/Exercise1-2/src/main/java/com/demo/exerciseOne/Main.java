package com.demo.exerciseOne;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Facu Paez
 * Crear proyecto maven con la dependencia spring-context y crear una clase Saludo con un método imprimirSaludo
 * que imprima un texto por consola.
 * Crear el archivo beans.xml con un bean para la clase Saludo.
 * Obtener el bean desde el método main y ejecutar el método imprimirSaludo.
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Greeting greeting = (Greeting) context.getBean("greeting");

        String printGreeting = greeting.printGreeting();
        System.out.println(printGreeting);
    }
}
