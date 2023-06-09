package com.example.demo.service;

import com.example.demo.entities.BookEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePriceTest() {
        // configuración de la prueba
        BookEntity book = new BookEntity(1L, "Harry Potter y la Orden del Fénix", "J. K. Rowling", 766, 32.99, LocalDate.of(2003, 05, 21), true, true);
        BookPriceCalculator bookPriceCalculator = new BookPriceCalculator();

        // se ejecuta el comportamiento a testear
        double price = bookPriceCalculator.calculatePrice(book);
        System.out.println(price);

        // aserciones
        assertTrue(price > 0);
        assertEquals(39.99, price);
    }
}