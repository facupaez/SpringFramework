package com.example.demo.behavorial.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShopCart {

    private List<Product> products;

    public ShopCart(){
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    // pagar utilizando una estrategia de pago
    public void pay(PaymentStrategy paymentStrategy){
        // iteramos de forma imperativa
        double amount = 0;
        for (Product product : products){
            amount += product.getPrice();
        }

        paymentStrategy.pay(amount);
    }
}
