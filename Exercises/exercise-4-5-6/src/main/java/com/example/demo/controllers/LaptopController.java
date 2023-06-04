package com.example.demo.controllers;

import com.example.demo.entities.Laptop;
import com.example.demo.repositories.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {

    LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }
}
