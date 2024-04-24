package org.example.model;

public class Phone {
    String id;
    String brand;
    String model;
    String color;
    double price;
    int storage;
    int ram;
    String os;

    public Phone(String id, String brand, String model, String color, double price, int storage, int ram, String os) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.storage = storage;
        this.ram = ram;
        this.os = os;

        System.out.println("Phone created:" + id);
    }

    public void call() {}
    public void sendSMS() {}
    public void takePicture() {}
    public void recordVideo() {}
    public void playMusic() {}
    public void playVideo() {}

}
