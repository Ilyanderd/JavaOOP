package ru.academits.povetkin.shapes;

import java.util.Comparator;

public class AreaCompare implements Comparator<Shape> {
    @Override
    public int compare(Shape one, Shape two) {
        return (int) (two.getArea() - one.getArea());
    }
}
