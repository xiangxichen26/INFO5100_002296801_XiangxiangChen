package org.example.model;

public class Computer {
    String id;
    String brand;
    String model;
    String color;
    double price;
    int ram;
    int storage;
    CPU cpu;

    public static class CPU{
        String brand;
        String model;
        int cores;
        int threads;
        double frequency;
        double cache;
        String socket;
        String architecture;
        String lithography;
        String power;
        String integratedGraphics;

        public CPU(String brand, String model, int cores, int threads, double frequency, double cache, String socket, String architecture, String lithography, String power, String integratedGraphics) {
            this.brand = brand;
            this.model = model;
            this.cores = cores;
            this.threads = threads;
            this.frequency = frequency;
            this.cache = cache;
            this.socket = socket;
            this.architecture = architecture;
            this.lithography = lithography;
            this.power = power;
            this.integratedGraphics = integratedGraphics;

            System.out.println("CPU created for Computer:" + model);

        }

        public void start() {}

        public void stop() {}

        public void execute() {}

    }

    public Computer(String id, String brand, String model, String color, double price, int ram, int storage, CPU cpu) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.ram = ram;
        this.storage = storage;
        this.cpu = cpu;

        System.out.println("Computer created:" + id);
    }

    public void turnOn() {}

    public void turnOff() {}

    public void upgrade() {}

}