package com.example.demo.structural.decorator.decorators;

import com.example.demo.structural.decorator.Photo;

public class RetroEffect extends PhotoDecorator{

    public RetroEffect(Photo photo) {
        super(photo);
    }

    @Override
    public String show() {
        // decorando foto
        this.photo.setBrightness(50);
        this.photo.setContrast(30);

        return this.photo.show() + " + Retro";
    }

    @Override
    public double cost() {
        return this.photo.cost() + 22;
    }
}
