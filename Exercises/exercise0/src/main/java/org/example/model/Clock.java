package org.example.model;
public class Clock {
    String id;
    String brand;
    String model;
    String color;
    String material;
    double price;
    String shape;
    String mechanism;

    public Clock(String id, String brand, String model, String color, String material, double price, String shape, String mechanism) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.material = material;
        this.price = price;
        this.shape = shape;
        this.mechanism = mechanism;

        System.out.println("Clock created:" + id);
    }

    public void setAlarm() {}
    public void stopAlarm() {}
    public void clean() {}
}

