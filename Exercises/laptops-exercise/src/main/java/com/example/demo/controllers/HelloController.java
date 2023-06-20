package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    String message;

    @GetMapping("/hello")
    public String helloWorld(){
        System.out.println(message);
        return "Hello world from exercise 1!";
    }

    @GetMapping("/bootstrap")
    public String bootstrap(){
        System.out.println(message);
        return "Welcome to Bootstrap User!";
    }
}
