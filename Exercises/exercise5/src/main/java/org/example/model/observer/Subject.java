package org.example.model.observer;

public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyUpdate(Shape shape);
}
