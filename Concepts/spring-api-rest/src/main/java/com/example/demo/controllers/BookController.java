package com.example.demo.controllers;

import com.example.demo.entities.BookEntity;
import com.example.demo.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    // atributos
    BookRepository bookRepository;
    private final Logger log = LoggerFactory.getLogger(BookController.class);

    // constructores
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CRUD sobre la entidad Book en base de datos

    /**
     * Buscar todos los libros existentes en base de datos
     * http://localhost:8080/books
     * @return
     */
    @GetMapping("/books")
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    /**
     * Buscar libro por id en base de datos
     * ResponseEntity ayuda a la api a entender las respuestas que debe emitir al tener errores
     * http://localhost:8080/books/1
     * @param id
     * @return
     */
    @GetMapping("/books/{id}")
    public ResponseEntity<BookEntity> findById(@PathVariable Long id) {
        Optional<BookEntity> bookOpt = bookRepository.findById(id);
        return bookOpt.isPresent() ? ResponseEntity.ok(bookOpt.get()) : ResponseEntity.notFound().build();
    }

    /**
     * Crear un nuevo libro en base de datos
     * Utilizamos @RequestHeader HttpHeaders para extraer cabeceras
     * http://localhost:8080/books
     * @param book
     * @param headers
     * @return
     */
    @PostMapping("/books")
    public ResponseEntity<BookEntity> create(@RequestBody BookEntity book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if(book.getId() != null){
            log.warn("Trying to create a book with an existent id");
            return ResponseEntity.badRequest().build();
        }
        BookEntity result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    /**
     * Modificar un libro de la base de datos
     * http://localhost:8080/books
     * @param book
     * @return
     */
    //
    @PutMapping("/books")
    public ResponseEntity<BookEntity> update(@RequestBody BookEntity book){
        if (book.getId() == null){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if (!bookRepository.existsById(book.getId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        BookEntity result = bookRepository.save(book);
        return ResponseEntity.ok(result);

    }

    /**
     * Eliminar un libro por id de la base de datos
     * http://localhost:8080/books
     * @param id
     * @return
     */
    //
    @DeleteMapping("/books/{id}")
    public ResponseEntity<BookEntity> delete(@PathVariable Long id){
        if (!bookRepository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }

        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
