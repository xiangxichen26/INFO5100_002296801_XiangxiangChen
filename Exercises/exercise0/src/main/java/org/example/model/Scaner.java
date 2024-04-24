package org.example.model;

public class Scaner {
    String id;
    String brand;
    String model;
    String color;
    double price;
    double width;
    int ppm;
    boolean duplex;
    boolean wifi;
    double maxScanSize;
    String power;

    public Scaner(String id, String brand, String model, String color, double price, double width, int ppm, boolean duplex, boolean wifi, double maxScanSize, String power) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.width = width;
        this.ppm = ppm;
        this.duplex = duplex;
        this.wifi = wifi;
        this.maxScanSize = maxScanSize;
        this.power = power;

        System.out.println("Scaner created:" + id);
    }

    public void scan() {}
    public void charge() {}
    public void turnOn() {}
    public void turnOff() {}
    public void adjustSize() {}
}
