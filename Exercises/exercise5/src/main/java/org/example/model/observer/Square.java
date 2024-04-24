package org.example.model.observer;

import java.util.ArrayList;
import java.util.List;

public class Square implements Shape, Subject {
    private List<Observer> observers = new ArrayList<>();
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public void setSide(int side) {
        this.side = side;
        notifyUpdate(this);
    }

    public int getSide() {
        return side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square with side " + side);
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