import model.factory.Shape;
import model.factory.ShapeFactoryPattern;
import model.observer.*;
import model.singleton.ShapeSingletonPattern;

public class Main {
    public static void main(String []args) {
        // Test ShapeFactoryPattern
        System.out.println("Test ShapeFactoryPattern");
        ShapeFactoryPattern shapeFactory = new ShapeFactoryPattern();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("Circle");
        shape1.draw();
        //get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("Rectangle");
        shape2.draw();
        //get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("Square");
        shape3.draw();
        //get an object of Triangle and call its draw method.
        Shape shape4 = shapeFactory.getShape("Triangle");
        shape4.draw();

        System.out.println("-------------------------------------------------------------");

        // Test ShapeSingletonPattern
        System.out.println("Test ShapeSingletonPattern");
        ShapeSingletonPattern shapeSingleton = ShapeSingletonPattern.getInstance();

        shapeSingleton.drawShape("Circle");
        shapeSingleton.drawShape("Square");
        shapeSingleton.drawShape("Rectangle");
        shapeSingleton.drawShape("Triangle");

        System.out.println("-------------------------------------------------------------");

        // Test ShapeObserverPattern
        System.out.println("Test ShapeObserverPattern");
        Circle circle = new Circle(5);
        Square square = new Square(5);
        Triangle triangle = new Triangle(5,10);
        Rectangle rectangle = new Rectangle(3,4);

        ShapeObserverPattern shapeObserver = new ShapeObserverPattern(circle, square, triangle, rectangle);

        circle.attach(shapeObserver);
        circle.setRadius(10);

        square.attach(shapeObserver);
        square.setSide(10);

        triangle.attach(shapeObserver);
        triangle.setBase(10);

        rectangle.attach(shapeObserver);
        rectangle.setWidth(6);
    }
}
