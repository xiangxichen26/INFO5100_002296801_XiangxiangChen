package org.example.model.observer;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape, Subject {
    private List<Observer> observers = new ArrayList<>();
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
        notifyUpdate(this);
    }

    public void setHeight(int height) {
        this.height = height;
        notifyUpdate(this);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle with width " + width + " and height " + height);
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
