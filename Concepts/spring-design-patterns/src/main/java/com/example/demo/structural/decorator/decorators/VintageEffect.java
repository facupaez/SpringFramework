package com.example.demo.structural.decorator.decorators;

import com.example.demo.structural.decorator.Photo;

public class VintageEffect extends PhotoDecorator{

    public VintageEffect(Photo photo) {
        super(photo);
    }

    @Override
    public String show() {
        // decorando foto
        this.photo.setBrightness(90);
        this.photo.setContrast(20);
        this.photo.setBlur(5);

        return this.photo.show() + " + Vintage";
    }

    @Override
    public double cost() {
        return this.photo.cost() + 15;
    }
}
