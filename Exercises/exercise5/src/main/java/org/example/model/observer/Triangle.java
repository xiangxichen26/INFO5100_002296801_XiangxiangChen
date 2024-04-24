package org.example.model.observer;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements Shape, Subject{
    private List<Observer> observers = new ArrayList<>();
    private int base;
    private int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public void setBase(int base) {
        this.base = base;
        notifyUpdate(this);
    }

    public void setHeight(int height) {
        this.height = height;
        notifyUpdate(this);
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle with base " + base + " and height " + height);
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
