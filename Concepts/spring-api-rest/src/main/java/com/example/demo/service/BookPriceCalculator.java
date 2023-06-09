package com.example.demo.service;

import com.example.demo.entities.BookEntity;

public class BookPriceCalculator {

    public double calculatePrice(BookEntity book){
        double price = book.getPrice();

        if (book.getPages() > 100){
            price += 5;
        }
        // envio
        if (book.isShipping()) price += 2;

        return price;
    }
}
