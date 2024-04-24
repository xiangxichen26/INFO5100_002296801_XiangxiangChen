package org.example.model.observer;

public class ShapeObserverPattern implements Observer{
    private Circle circle;
    private Square square;
    private Triangle triangle;
    private Rectangle rectangle;

    public ShapeObserverPattern(Circle circle, Square square, Triangle triangle, Rectangle rectangle) {
        this.circle = circle;
        this.square = square;
        this.triangle = triangle;
        this.rectangle = rectangle;
    }

    @Override
    public void update(Shape shape) {
        if (shape instanceof Circle) {
            System.out.println("Circle radius changes to: " + circle.getRadius());
        } else if (shape instanceof Square) {
            System.out.println("Square side changes to: " + square.getSide());
        } else if (shape instanceof Triangle) {
            System.out.println("Triangle changes to: " + "Base: " + triangle.getBase() + " Height: " + triangle.getHeight());
        } else if (shape instanceof Rectangle) {
            System.out.println("Rectangle changes to: " + "Width: " + rectangle.getWidth() + " Height: " + rectangle.getHeight());
        }
    }
}
