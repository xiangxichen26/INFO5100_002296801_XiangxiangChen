package model;

import java.io.Serializable;

public class Square extends Shape implements Serializable {
    private final double side;

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
