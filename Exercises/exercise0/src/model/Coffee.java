package model;

public class Coffee {
    String id;
    String brand;
    String model;
    String color;
    double price;
    double capacity;
    boolean grinder;
    boolean milkFrother;

    public Coffee(String id, String brand, String model, String color, double price, double capacity, boolean grinder, boolean milkFrother) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.capacity = capacity;
        this.grinder = grinder;
        this.milkFrother = milkFrother;

        System.out.println("Coffee created:" + id);
    }

    public void fillWater() {}
    public void grindBeans() {}
    public void drink() {}

}
