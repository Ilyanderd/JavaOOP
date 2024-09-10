package ru.academits.povetkin.shapes;

import java.util.Objects;

public class Rectangle implements Shape {
    private double sideLength1;
    private double sideLength2;

    public Rectangle(double sideLength1, double sideLength2) {
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
    }

    @Override
    public String toString() {
        return "Rectangle {" +
                "sideLength1 = " + sideLength1 +
                ", sideLength2 = " + sideLength2 +
                ", area = " + getArea() +
                ", perimeter = " + getPerimeter() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;

        return Double.compare(sideLength1, rectangle.sideLength1) == 0 && Double.compare(sideLength2, rectangle.sideLength2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideLength1, sideLength2);
    }

    public double getSideLength1() {
        return sideLength1;
    }

    public void setSideLength1(double sideLength1) {
        this.sideLength1 = sideLength1;
    }

    public double getSideLength2() {
        return sideLength2;
    }

    public void setSideLength2(double sideLength2) {
        this.sideLength2 = sideLength2;
    }

    @Override
    public double getWidth() {
        return sideLength1;
    }

    @Override
    public double getHeight() {
        return sideLength2;
    }

    @Override
    public double getArea() {
        return sideLength1 * sideLength2;
    }

    @Override
    public double getPerimeter() {
        return 2 * sideLength1 + 2 * sideLength2;
    }
}
