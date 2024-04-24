package org.example.model.singleton;

public class ShapeSingletonPattern {
    private static ShapeSingletonPattern instance = new ShapeSingletonPattern();

    private ShapeSingletonPattern(){

    }

    public static ShapeSingletonPattern getInstance(){
        return instance;
    }

    public void drawShape(String shapeType) {
        if (shapeType == null){
            return;
        }

        if (shapeType.equalsIgnoreCase("Circle")) {
            new Circle().draw();
        }else if (shapeType.equalsIgnoreCase("Square")) {
            new Square().draw();
        }else if (shapeType.equalsIgnoreCase("Rectangle")) {
            new Rectangle().draw();
        }else if (shapeType.equalsIgnoreCase("Triangle")) {
            new Triangle().draw();
        }
    }

}
