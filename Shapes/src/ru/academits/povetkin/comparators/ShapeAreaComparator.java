package ru.academits.povetkin.comparators;

import ru.academits.povetkin.shapes.Shape;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape firstShape, Shape secondShape) {
        return Double.compare(firstShape.getArea(), secondShape.getArea());
    }
}
