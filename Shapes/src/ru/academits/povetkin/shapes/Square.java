package ru.academits.povetkin.shapes;

import java.util.Objects;

import static java.lang.Math.pow;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Square {" +
                "sideLength = " + sideLength +
                ", area = " + getArea() +
                ", perimeter = " + getPerimeter() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(sideLength, square.sideLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sideLength);
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return pow(sideLength, 2);
    }
}
