package com.example.demo.controllers;

import com.example.demo.entities.Laptop;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// definimos un puerto random
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    // configuramos variabes para poder usar métodos http
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void createTest() {
        Laptop laptop = new Laptop("Windows 10", "black", 15.6, 1, 16, "i7", true);

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Laptop> httpEntity = new HttpEntity<>(laptop, headers);

        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/laptops", httpEntity,
                String.class);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    /*@Test
    void updateTest() {
        Laptop laptop = new Laptop("Windows 1111", "black", 15.6, 1, 16, "i7", true);

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Laptop> httpEntity = new HttpEntity<>(laptop, headers);

        ResponseEntity<String> responseEntity = testRestTemplate.exchange("/laptops/1", HttpMethod.PUT,
                httpEntity, String.class);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }*/

   /* @Test
    void findByIdTest() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/laptops/1", Laptop.class);

        Laptop laptop = response.getBody();
        System.out.println("laptop = " + laptop);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }*/

    @Test
    void findAllTest() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/laptops", String.class);

        String laptops = responseEntity.getBody();

        System.out.println(laptops);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

   /* @Test
    void deleteTest() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Laptop> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<String> responseEntity = testRestTemplate.exchange("/laptops/1", HttpMethod.DELETE,
                httpEntity, String.class);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }*/

    @Test
    void deleteAllTest() {

    }

}