package ru.academits.povetkin.shapes_main;

import ru.academits.povetkin.comparators.ShapeAreaComparator;
import ru.academits.povetkin.comparators.ShapePerimeterComparator;
import ru.academits.povetkin.shapes.*;

import java.util.ArrayList;

public class Main {
    public static Shape getShapeWithMaxArea(ArrayList<Shape> shapes) {
        shapes.sort(new ShapeAreaComparator());

        return shapes.get(shapes.size() - 1);
    }

    public static Shape getShapeWithSecondMaxPerimeter(ArrayList<Shape> shapes) {
        shapes.sort(new ShapePerimeterComparator());

        return shapes.get(shapes.size() - 2);
    }

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(10.5));
        shapes.add(new Rectangle(5.5, 15.1));
        shapes.add(new Square(13));
        shapes.add(new Triangle(1.2, 2, 4.6, 3.2, 6.4, 8.7));
        shapes.add(new Square(18.9));

        System.out.println(getShapeWithMaxArea(shapes));
        System.out.println(getShapeWithSecondMaxPerimeter(shapes));
    }
}