package ru.academits.povetkin.vector_main;

import ru.academits.povetkin.vector.Vector;

import static ru.academits.povetkin.vector.Vector.*;

public class Main {
    public static void main(String[] args) {
        try {
            double[] array1 = {1, 2, 3, 4, 5, 6};
            double[] array2 = {6, 7, 8, 9, 10};

            Vector vector1 = new Vector(array1);
            Vector vector2 = new Vector(array2);

            Vector addition = vector1.getComponentsAddition(vector2);
            System.out.println("Результат прибавления: " + addition);

            Vector subtraction = vector1.getComponentsSubtraction(vector2);
            System.out.println("Результат вычитания: " + subtraction);

            vector1.multiplicationComponents(2.0);
            System.out.println("Результат умножения на скаляр: " + vector1);

            vector1.reverseComponents();
            System.out.println("Результат разворота вектора: " + vector1);

            System.out.println("Длина вектора: " + vector1.getLength());

            System.out.println("Результат сложения векторов: " + getVectorsAddition(vector1, vector2));

            System.out.println("Результат разности векторов: " + getVectorsSubtraction(vector1, vector2));

            System.out.println("Результат скалярного произведения векторов: " + getScalarMultiplication(vector1, vector2));
        } catch (IllegalArgumentException exception) {
            System.out.println("Ошибка!");
        }
    }
}