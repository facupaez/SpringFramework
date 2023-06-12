package com.example.demo.controllers;

import com.example.demo.exception.LaptopNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LaptopExceptionController {

    @ExceptionHandler(value = LaptopNotFoundException.class)
    public ResponseEntity<Object> exception(LaptopNotFoundException exception){
        return new ResponseEntity<>("Laptop not found", HttpStatus.NOT_FOUND);
    }



}
