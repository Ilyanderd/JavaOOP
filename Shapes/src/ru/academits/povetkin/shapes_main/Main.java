package ru.academits.povetkin.shapes_main;

import ru.academits.povetkin.shapes.*;

import java.util.ArrayList;

public class Main {
    public static Shape getShapeMaxArea(ArrayList<Shape> shapes) {
        AreaCompare areaCompare = new AreaCompare();
        shapes.sort(areaCompare);
        System.out.println(shapes);

        return shapes.get(0);
    }

    public static Shape getShapeSecondMaxPerimeter(ArrayList<Shape> shapes) {
        PerimeterCompare perimeterCompare = new PerimeterCompare();
        shapes.sort(perimeterCompare);
        System.out.println(shapes);

        return shapes.get(1);
    }

    public static void main(String[] args) {
        Circle circle = new Circle(10.5);
        Rectangle rectangle = new Rectangle(5.5, 15.1);
        Square square1 = new Square(13);
        Triangle triangle = new Triangle(1.2, 2, 4.6, 3.2, 6.4, 8.7);
        Square square2 = new Square(18.9);

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(square1);
        shapes.add(triangle);
        shapes.add(square2);

        System.out.println(getShapeMaxArea(shapes));
        System.out.println(getShapeSecondMaxPerimeter(shapes));
    }
}