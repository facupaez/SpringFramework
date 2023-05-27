package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Facu Paez
 * Tema: Spring Framework.
 * Creando proyecto HelloWorld con Spring Framework.
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        // Creamos un contenedor de beans
        // Instanciamos el objeto GreetingsService sin escribirlo ya que Spring lo hace por nosotros.
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        GreetingsService greetings = (GreetingsService) context.getBean("greetingsService");

        String greeting = greetings.helloWorld();
        System.out.println(greeting);
        }
}
