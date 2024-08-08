package ru.academits.povetkin.shapes;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    public Triangle(double x1,double x2,double x3,double y1, double y2, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        double intermediateMaximumX = max(x1,x2);
        double intermediateMinimumY = min(y1,y2);
        return max(intermediateMaximumX,x3) - min(intermediateMinimumY,y3);
    }

    @Override
    public double getHeight() {
        double intermediateMaximumY = max(y1,y2);
        double intermediateMinimumX = min(x1,x2);
        return max(intermediateMaximumY,y3) - min(intermediateMinimumX,x3);
    }

    @Override
    public double getArea() {
        return 0.5 * (y2-x2) * getHeight();
    }

    @Override
    public double getPerimeter() {
        return (y1-x1) + (y2-x2) + (y3-x3);
    }
}
