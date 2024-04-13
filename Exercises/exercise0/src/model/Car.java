package model;

public class Car {
    String id;
    String brandName;
    String modelName;
    String color;
    String fuelType;
    double price;
    int doors;
    int seats;
    int year;
    Engine engine;

    public static class Engine {
        String type;
        int power;
        int torque;
        int displacement;
        int cylinders;
        int valves;
        String fuelType;
        String transmission;
        String drive;
        String traction;
        String fuelConsumption;
        String emissions;

        public Engine(String type, int power, int torque, int displacement, int cylinders, int valves, String fuelType, String transmission, String drive, String traction, String fuelConsumption, String emissions) {
            this.type = type;
            this.power = power;
            this.torque = torque;
            this.displacement = displacement;
            this.cylinders = cylinders;
            this.valves = valves;
            this.fuelType = fuelType;
            this.transmission = transmission;
            this.drive = drive;
            this.traction = traction;
            this.fuelConsumption = fuelConsumption;
            this.emissions = emissions;

            System.out.println("Engine created for Car:" + type);
        }

        public void start() {}

        public void stop() {}

        public void accelerate() {}

    }

    public Car(String id, String brandName, String modelName, String color, String fuelType, double price, int doors, int seats, int year, Engine engine) {
        this.id = id;
        this.brandName = brandName;
        this.modelName = modelName;
        this.color = color;
        this.fuelType = fuelType;
        this.price = price;
        this.doors = doors;
        this.seats = seats;
        this.year = year;
        this.engine = engine;

        System.out.println("Car created:" + id);
    }

    public void drive() {}

    public void stop() {}

    public void refuel() {}

}

