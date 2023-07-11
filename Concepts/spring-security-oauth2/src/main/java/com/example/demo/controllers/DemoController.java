package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/home")
    public String hello(){
        return "Hello home!";
    }

    @GetMapping("/secured")
    public String secured(){
        return "Hello from secured!!";
    }
}
