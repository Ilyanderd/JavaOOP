package ru.academits.povetkin.range_main;

import ru.academits.povetkin.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(10, 100);
        Range range2 = new Range(11, 20);

        Range resultRange = range1.intersection(range2);
        System.out.println("Пересечение");
        System.out.println("Начало диапазона = " + resultRange.getFrom());
        System.out.println("Конец диапазона = " + resultRange.getTo());

        System.out.println("-------------------------------------------------");

        range1.setFrom(12);
        range1.setTo(18);

        Range[] resultArrayRange = range1.consolidation(range2);
        System.out.println("Объединение");
        System.out.println("Начало первого диапазона = " + resultArrayRange[0].getFrom());
        System.out.println("Конец первого диапазона = " + resultArrayRange[0].getTo());

        if (resultArrayRange[1] != null) {
            System.out.println("Начало второго диапазона = " + resultArrayRange[1].getFrom());
            System.out.println("Конец второго диапазона = " + resultArrayRange[1].getTo());
        }

        System.out.println("-------------------------------------------------");

        range1.setFrom(11);
        range1.setTo(20);

        resultArrayRange = range1.difference(range2);
        System.out.println("Разность");
        System.out.println("Начало первого диапазона = " + resultArrayRange[0].getFrom());
        System.out.println("Конец первого диапазона = " + resultArrayRange[0].getTo());

        if (resultArrayRange[1] != null) {
            System.out.println("Начало второго диапазона = " + resultArrayRange[1].getFrom());
            System.out.println("Конец второго диапазона = " + resultArrayRange[1].getTo());
        }
    }
}
