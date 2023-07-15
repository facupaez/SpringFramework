package com.example.demo.structural.proxy;

public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void showImage() {
        // el objeto realImage se crea solo la primera vez.
        if (realImage == null){
            this.realImage = new RealImage(fileName);
        }

        realImage.showImage();
    }
}
