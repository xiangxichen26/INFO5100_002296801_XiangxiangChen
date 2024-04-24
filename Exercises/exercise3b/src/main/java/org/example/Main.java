package org.example;

import org.example.model.*;
import java.io.*;

public class Main {
    public static class SerializationUtil {
        // Method to serialize an object to a file
        public static void serialize(Object obj, String fileName) throws IOException {
            try (FileOutputStream fos = new FileOutputStream(fileName);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(obj);
            }
        }

        // Method to deserialize an object from a file
        public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
            try (FileInputStream fis = new FileInputStream(fileName);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                return ois.readObject();
            }
        }
    }

    public static void main(String[] ars) throws IOException, ClassNotFoundException {

        // Initialize and serialize shapes
        Circle circle = new Circle("red", 5);
        SerializationUtil.serialize(circle, "circle.ser");

        Rectangle rectangle = new Rectangle("blue", 5, 10);
        SerializationUtil.serialize(rectangle, "rectangle.ser");

        Square square = new Square("green", 5);
        SerializationUtil.serialize(square, "square.ser");

        Triangle triangle = new Triangle("yellow", 3, 4, 5);
        SerializationUtil.serialize(triangle, "triangle.ser");

        // Deserialize shapes
        Circle deserializedCircle = (Circle) SerializationUtil.deserialize("circle.ser");
        Rectangle deserializedRectangle = (Rectangle) SerializationUtil.deserialize("rectangle.ser");
        Square deserializedSquare = (Square) SerializationUtil.deserialize("square.ser");
        Triangle deserializedTriangle = (Triangle) SerializationUtil.deserialize("triangle.ser");

        // Test deserialization by printing areas and perimeters
        System.out.println("Deserialized Circle area: " + deserializedCircle.calculateArea());
        System.out.println("Deserialized Circle perimeter: " + deserializedCircle.calculatePerimeter());
        System.out.println("Deserialized Circle color: " + deserializedCircle.getColor());

        System.out.println("Deserialized Rectangle area: " + deserializedRectangle.calculateArea());
        System.out.println("Deserialized Rectangle perimeter: " + deserializedRectangle.calculatePerimeter());
        System.out.println("Deserialized Rectangle color: " + deserializedRectangle.getColor());

        System.out.println("Deserialized Square area: " + deserializedSquare.calculateArea());
        System.out.println("Deserialized Square perimeter: " + deserializedSquare.calculatePerimeter());
        System.out.println("Deserialized Square color: " + deserializedSquare.getColor());

        System.out.println("Deserialized Triangle area: " + deserializedTriangle.calculateArea());
        System.out.println("Deserialized Triangle perimeter: " + deserializedTriangle.calculatePerimeter());
        System.out.println("Deserialized Triangle color: " + deserializedTriangle.getColor());

    }
}