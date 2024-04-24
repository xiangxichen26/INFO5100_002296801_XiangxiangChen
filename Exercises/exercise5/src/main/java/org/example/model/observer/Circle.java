package org.example.model.observer;

import java.util.ArrayList;
import java.util.List;

public class Circle implements Shape, Subject {
    private List<Observer> observers = new ArrayList<>();
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        notifyUpdate(this);
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle with radius " + radius);
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyUpdate(Shape shape) {
        for (Observer o : observers) {
            o.update(shape);
        }
    }
}
