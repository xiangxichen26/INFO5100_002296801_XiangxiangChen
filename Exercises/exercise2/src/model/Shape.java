package model;

public abstract class Shape {
    public String color;

    public Shape(String color) {
        this.color = color;
    }
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}