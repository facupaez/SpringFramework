package com.example.demo.controllers;

import com.example.demo.entities.BookEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// definimos un puerto random
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    // configuramos variabes para poder usar métodos http
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void hello() {
        ResponseEntity<String> response =
                testRestTemplate.getForEntity("/hello", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hello world!", response.getBody());
    }

    @Test
    void bootstrap() {
        ResponseEntity<String> response =
                testRestTemplate.getForEntity("/bootstrap", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("""
                  <!doctype html>
                   <html lang="en">
                     <head>
                       <meta charset="utf-8">
                       <meta name="viewport" content="width=device-width, initial-scale=1">
                       <title>Bootstrap demo</title>
                       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
                     </head>
                     <body>
                       <h1>Hello, world from Spring Boot with Bootstrap!</h1>
                       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
                     </body>
                   </html>
                """, response.getBody());
    }

    @Test
    void findAllTest() {
        ResponseEntity<BookEntity[]> response =
                testRestTemplate.getForEntity("/books", BookEntity[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<BookEntity> books = Arrays.asList(response.getBody());
        System.out.println(books.size());
    }

    @Test
    void findByIdTest() {
        ResponseEntity<BookEntity> response =
                testRestTemplate.getForEntity("/books/1", BookEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void createTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "title": "Harry Potter y la Orden del Fénix",
                    "author": "J. K. Rowling",
                    "pages": 766,
                    "price": 32.99,
                    "releaseDate": "2003-05-21",
                    "online": true,
                    "shipping": true
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<BookEntity> response = testRestTemplate.exchange("/books", HttpMethod.POST, request, BookEntity.class);

        BookEntity result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("Harry Potter y la Orden del Fénix", result.getTitle());
    }
}