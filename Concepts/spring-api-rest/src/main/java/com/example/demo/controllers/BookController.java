package com.example.demo.controllers;

import com.example.demo.entities.BookEntity;
import com.example.demo.repositories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    // buscar libro por id
    @GetMapping("/books/{id}")
    // usando ResponseEntity ayudamos a la api a entender las respuetas que debe emitir al tener errores
    public ResponseEntity<BookEntity> findById(@PathVariable Long id) {
        Optional<BookEntity> bookOpt = bookRepository.findById(id);
        return bookOpt.isPresent() ? ResponseEntity.ok(bookOpt.get()) : ResponseEntity.notFound().build();
    }

    // crear un nuevo libro

    // modificar un libro

    // eliminar un libro
}
