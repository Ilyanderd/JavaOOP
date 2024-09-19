package ru.academits.povetkin.vector;

import java.util.Arrays;
import java.util.Objects;

public class Vector {
    private int size;
    private double[] vectorComponents;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Некореректный размер вектора!");
        }

        this.size = size;
        vectorComponents = new double[size];
    }

    public Vector(Vector vector) {
        size = vector.size;
        vectorComponents = vector.vectorComponents;
    }

    public Vector(double[] array) {
        size = array.length;
        vectorComponents = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            vectorComponents[i] = array[i];
        }
    }

    public Vector(int size, double[] array) throws IllegalArgumentException {
        if (size <= 0) {
            throw new IllegalArgumentException("Некореректный размер вектора!");
        }

        this.size = size;
        vectorComponents = new double[size];

        for (int i = 0; i < array.length; i++) {
            vectorComponents[i] = array[i];
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(vectorComponents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        return size == vector.size && Objects.deepEquals(vectorComponents, vector.vectorComponents);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + size;
        hash = prime * hash + Arrays.hashCode(vectorComponents);

        return hash;
    }

    public Vector getComponentsAddition(Vector vector) {
        Vector resultVector;

        if (size < vector.size) {
            resultVector = new Vector(vector.size, vectorComponents);

            for (int i = 0; i < resultVector.size; i++) {
                resultVector.vectorComponents[i] += vector.vectorComponents[i];
            }
        } else {
            resultVector = new Vector(size, vector.vectorComponents);

            for (int i = 0; i < resultVector.size; i++) {
                resultVector.vectorComponents[i] += vectorComponents[i];
            }
        }

        return resultVector;
    }

    public Vector getComponentsSubtraction(Vector vector) {
        Vector resultVector;

        if (size < vector.size) {
            resultVector = new Vector(vector.size, vectorComponents);

            for (int i = 0; i < resultVector.size; i++) {
                resultVector.vectorComponents[i] -= vector.vectorComponents[i];
            }
        } else {
            resultVector = new Vector(size, vector.vectorComponents);

            for (int i = 0; i < resultVector.size; i++) {
                resultVector.vectorComponents[i] -= vectorComponents[i];
            }
        }

        return resultVector;
    }

    public void multiplicationComponents(double scalar) {
        for (int i = 0; i < size; i++) {
            vectorComponents[i] *= scalar;
        }
    }

    public void reverseComponents() {
        for (int i = 0; i < size; i++) {
            vectorComponents[i] *= -1;
        }
    }

    public double getLength() {
        double result = 0;

        for (int i = 0; i < size; i++) {
            result += Math.sqrt(Math.pow(vectorComponents[i], 2));
        }

        return result;
    }

    public double getVectorComponent(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Индекс выходит за границу вектора!");
        }

        return vectorComponents[index];
    }

    public void setVectorComponent(int index, double value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Индекс выходит за границу вектора!");
        }

        vectorComponents[index] = value;
    }


    public static Vector getVectorsAddition(Vector vector1, Vector vector2) {
        int resultSize = vector1.size + vector2.size;
        Vector resultVector = new Vector(resultSize, vector1.vectorComponents);
        int k = 0;

        for (int i = Math.max(vector1.size, vector2.size); i < resultSize; i++) {
            resultVector.vectorComponents[i] = vector2.vectorComponents[k];

            k++;
        }

        return resultVector;
    }

    public static Vector getVectorsSubtraction(Vector vector1, Vector vector2) {
        int resultSize = Math.abs(vector1.size - vector2.size);

        if (resultSize == 0) {
            return new Vector(0);
        }

        Vector resultVector = new Vector(resultSize);
        int startIndex = Math.min(vector1.size, vector2.size);

        if (vector1.size < vector2.size) {
            for (int i = 0; i < resultSize; i++) {
                resultVector.vectorComponents[i] = vector2.vectorComponents[startIndex];

                startIndex++;
            }
        } else {
            for (int i = 0; i < resultSize; i++) {
                resultVector.vectorComponents[i] = vector1.vectorComponents[startIndex];

                startIndex++;
            }
        }

        return resultVector;
    }

    public static double getScalarMultiplication(Vector vector1, Vector vector2) {
        double result = 0;

        if (vector1.size < vector2.size) {
            Vector supportVector = new Vector(vector2.size, vector1.vectorComponents);

            for (int i = 0; i < supportVector.size; i++) {
                result += supportVector.vectorComponents[i] * vector2.vectorComponents[i];
            }
        } else if (vector1.size > vector2.size) {
            Vector supportVector = new Vector(vector1.size, vector2.vectorComponents);

            for (int i = 0; i < supportVector.size; i++) {
                result += supportVector.vectorComponents[i] * vector1.vectorComponents[i];
            }
        } else {
            for (int i = 0; i < vector1.size; i++) {
                result += vector1.vectorComponents[i] * vector2.vectorComponents[i];
            }
        }

        return result;
    }
}