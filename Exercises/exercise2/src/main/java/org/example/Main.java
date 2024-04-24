package org.example;

import org.example.model.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        // Create a Circle object with color "red" and radius 5
        Circle circle = new Circle("red", 5);
        // Create a Rectangle object with color "blue", length 5 and width 10
        Rectangle rectangle = new Rectangle("blue", 5, 10);
        // Create a Square object with color "green" and side 5
        Square square = new Square("green", 5);
        // create triangle object with color "yellow" and sides 3, 4, 5
        Triangle triangle = new Triangle("yellow", 3, 4, 5);
        // Print the area and perimeter of each object
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Circle perimeter: " + circle.calculatePerimeter());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        System.out.println("Rectangle perimeter: " + rectangle.calculatePerimeter());
        System.out.println("Square area: " + square.calculateArea());
        System.out.println("Square perimeter: " + square.calculatePerimeter());
        System.out.println("Triangle area: " + triangle.calculateArea());
        System.out.println("Triangle perimeter: " + triangle.calculatePerimeter());
    }
}