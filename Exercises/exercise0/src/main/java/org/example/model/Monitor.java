package org.example.model;

public class Monitor {
    String id;
    String brand;
    String model;
    String color;
    double price;
    double width;
    double height;
    int refreshRate;
    double responseTime;

    public Monitor(String id, String brand, String model, String color, double price, double width, double height, int refreshRate, double responseTime) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.width = width;
        this.height = height;
        this.refreshRate = refreshRate;
        this.responseTime = responseTime;

        System.out.println("Monitor created:" + id);
    }

    public void turnOn() {}
    public void turnOff() {}
    public void adjustBrightness() {}
}

