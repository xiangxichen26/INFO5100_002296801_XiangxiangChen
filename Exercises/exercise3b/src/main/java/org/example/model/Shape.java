package org.example.model;

import java.io.Serializable;

public abstract class Shape implements Serializable {

    private static final long serialVersionUID = 1L;

    public String color;
    public Shape(String color) {
        this.color = color;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    public abstract String getColor();
}