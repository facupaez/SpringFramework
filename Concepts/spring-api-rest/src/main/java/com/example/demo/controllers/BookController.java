package com.example.demo.controllers;

import com.example.demo.entities.BookEntity;
import com.example.demo.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    // atributos
    BookRepository bookRepository;

    // constructores
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CRUD sobre la entidad Book en base de datos

    // buscar todos los libros
    @GetMapping("/books")
    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }

    // buscar libro por id

    // crear un nuevo libro

    // modificar un libro

    // eliminar un libro
}
