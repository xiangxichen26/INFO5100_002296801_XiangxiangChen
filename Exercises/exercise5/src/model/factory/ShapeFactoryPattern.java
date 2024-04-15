package model.factory;

public class ShapeFactoryPattern {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        }else if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        }else if (shapeType.equalsIgnoreCase("Triangle")) {
            return new Triangle();
        }
        return null;
    }
}
