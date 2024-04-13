package model;

public class Desk {
    String id;
    String brand;
    String model;
    String color;
    String material;
    double price;
    double width;
    double height;
    double depth;
    int drawers;

    public Desk(String id, String brand, String model, String color, String material, double price, double width, double height, double depth, int drawers) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.material = material;
        this.price = price;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.drawers = drawers;

        System.out.println("Desk created:" + id);
    }

    public void openDrawer() {}
    public void closeDrawer() {}
    public void clean() {}
    public void paint() {}
}
