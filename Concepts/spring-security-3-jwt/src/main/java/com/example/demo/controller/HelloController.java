package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/notSecured")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('GUEST')")
    public String hello(){
        return "Hello World Not Secured";
    }

    @GetMapping("/secured")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public String helloSecured(){
        return "Hello World Secured";
    }
}
