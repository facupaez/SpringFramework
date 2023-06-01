package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);
        BookRepository repository = context.getBean(BookRepository.class);

        // métodos CRUD
        // crear libro
        Book book1 = new Book(null, "Harry Potter y la piedra filosofal", "J.K. Rowling", 223, 27.99, LocalDate.of(1997, 6, 1), true);
        Book book2 = new Book(null, "Harry Potter y la cámara secreta", "J.K. Rowling", 251, 27.99, LocalDate.of(1998, 7, 2), true);

        // consultar cantidad de libros
        System.out.println("Cantidad de libros en base de datos: " + repository.findAll().size());

        // almacenar libro
        repository.save(book1);
        repository.save(book2);

        // consultar cantidad de libros
        System.out.println("Cantidad de libros en base de datos: " + repository.findAll().size());
        System.out.println("Consulta todos los libros de bases de datos: " + repository.findAll());

        // borrar un libro
        repository.delete(book2);

        // consultar cantidad de libros
        System.out.println("Cantidad de libros en base de datos: " + repository.findAll().size());
    }

}
