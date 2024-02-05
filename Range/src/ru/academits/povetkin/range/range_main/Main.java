package ru.academits.povetkin.range.range_main;

import ru.academits.povetkin.range.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(10.5, 100.7);

        double number = 12.5;

        System.out.println("to = " + range.getTo());
        System.out.println("from = " + range.getFrom());

        range.setTo(30.3);
        range.setFrom(11.9);

        System.out.println("to = " + range.getTo());
        System.out.println("from = " + range.getFrom());

        System.out.println("Длина диапазона = " + range.getLength());

        if (range.isInside(number)) {
            System.out.println("Число входит в диапазон");
        } else {
            System.out.println("Число не входит в диапазон");
        }
    }
}
