package ru.academits.povetkin.range_main;

import ru.academits.povetkin.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(6, 15);
        Range range2 = new Range(8, 12);

        System.out.println(range1.isInside(10));

        Range intersection = range1.getIntersection(range2);
        System.out.println("Интервал-пересечение: " + intersection);

        range2.setFrom(12);
        range2.setTo(20);

        Range[] union = range1.getUnion(range2);
        System.out.println("Объединение: " + Arrays.toString(union));

        range2.setFrom(8);
        range2.setTo(12);

        Range[] difference = range1.getDifference(range2);
        System.out.println("Разность: " + Arrays.toString(difference));
    }
}