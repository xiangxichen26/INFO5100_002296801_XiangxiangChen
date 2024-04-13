package model;

public class Tea {
    String id;
    String brand;
    String type;
    String city;
    double price;
    double capacity;
    double weight;
    int temperature;


    public Tea(String id, String brand, String type, String city, double price, double capacity, double weight, int temperature) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.city = city;
        this.price = price;
        this.capacity = capacity;
        this.weight = weight;
        this.temperature = temperature;

        System.out.println("Tea created:" + id);
    }

    public void heat() {}
    public void cool() {}
    public void addTea() {}
    public void addSugar() {}
    public void addLemon() {}
    public void stir() {}
    public void drink() {}
}
