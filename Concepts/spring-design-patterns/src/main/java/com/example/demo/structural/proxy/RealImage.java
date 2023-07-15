package com.example.demo.structural.proxy;

public class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading image... " + fileName);
    }

    @Override
    public void showImage() {
        System.out.println("Showing " + fileName);
    }
}
