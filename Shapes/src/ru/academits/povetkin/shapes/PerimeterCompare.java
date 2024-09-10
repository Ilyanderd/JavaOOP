package ru.academits.povetkin.shapes;

import java.util.Comparator;

public class PerimeterCompare implements Comparator<Shape> {
    @Override
    public int compare(Shape one, Shape two) {
        return (int) (two.getPerimeter() - one.getPerimeter());
    }
}
