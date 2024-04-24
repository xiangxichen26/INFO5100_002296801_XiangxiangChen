package org.example.model;

public class Printer {
    String id;
    String brand;
    String model;
    String color;
    double price;
    double width;
    double height;
    boolean isLaser;
    boolean isColor;

    public Printer(String id, String brand, String model, String color, double price, double width, double height, boolean isLaser, boolean isColor) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.width = width;
        this.height = height;
        this.isLaser = isLaser;
        this.isColor = isColor;

        System.out.println("Printer created:" + id);
    }

    public void print() {}
    public void copy() {}
    public void turnOn() {}
    public void turnOff() {}
    public void adjustColor() {}
    public void adjustSize() {}
}
