package com.demo.exerciseTwo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Facu Paez
 * Crear la clase NotificationService, con un método que imprima un saludo.
 * Crear una clase UserService que tenga un atributo de clase NotificationService.
 * Utilizar la anotación @Component en cada clase.
 * Habilitar el escaneo de clases en el archivo beans.xml
 * Desde el método main, probar a obtener el bean UserService y ejecutar el método imprimirSaludo que tiene
 * asociado el atributo de tipo NotificationService. De forma similar a la realizada en clase.
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        NotificationService notificationService = (NotificationService) context.getBean("notificationService");

        // Cargar bean individual
        String notification = notificationService.printGreeting();
        System.out.println(notification);

        // Cargar un bean dentro de otro bean.
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService.getNotificationService().printGreeting());
    }
}
