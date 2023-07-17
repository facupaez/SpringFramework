package com.example.demo.structural.decorator.decorators;

import com.example.demo.structural.decorator.Photo;

public abstract class PhotoDecorator extends Photo {
    protected Photo photo; // podria ser una foto real o un decorador porque ambos extienden de la clase Photo

    protected PhotoDecorator(Photo photo){
        this.photo = photo;
    }
}
