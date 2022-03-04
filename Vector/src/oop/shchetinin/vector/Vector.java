package oop.shchetinin.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("Vector size must be > 0, vectorSize = " + vectorSize);
        }

        components = new double[vectorSize];
    }

    public Vector(double[] components) {
        if (components == null) {
            throw new NullPointerException("Components must be not null!");
        }

        if (components.length == 0) {
            throw new IllegalArgumentException("Vector size must be > 0, n = " + components.length);
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int vectorSize, double[] components) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("Vector size must be > 0, vectorSize = " + vectorSize);
        }

        if (components == null) {
            throw new NullPointerException("Components must be not null!");
        }

        this.components = Arrays.copyOf(components, vectorSize);
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public int getSize() {
        return components.length;
    }

    public int[] getLength() {
        return new int[]{0, components.length - 1};
    }

    public double getComponentByIndex(int index) {
        if (index >= components.length) {
            throw new IllegalArgumentException("Index must be < component length, index = " + index);
        }

        return components[index];
    }

    public void setComponentByIndex(int index, double component) {
        components[index] = component;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (double component : components) {
            sb.append(component)
                    .append(", ");
        }

        sb.delete(sb.length() - 2, sb.length())
                .append("}");

        return sb.toString();
    }

    public void append(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        if (components.length > vector.components.length) {
            vector.components = Arrays.copyOf(vector.components, components.length);
        }

        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] + vector.components[i];
        }
    }

    public void subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        if (components.length > vector.components.length) {
            vector.components = Arrays.copyOf(vector.components, components.length);
        }

        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] - vector.components[i];
        }
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);

        resultVector.append(vector2);

        return resultVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);

        resultVector.subtract(vector2);

        return resultVector;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        if (vector1.components.length < vector2.components.length) {
            vector1.components = Arrays.copyOf(vector1.components, vector2.components.length);
        }

        if (vector1.components.length > vector2.components.length) {
            vector2.components = Arrays.copyOf(vector2.components, vector1.components.length);
        }

        double result = 0;

        for (int i = 0; i < vector1.components.length; i++) {
            result += vector1.components[i] * vector2.components[i];
        }

        return result;
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void reverse() {
        multiplyByScalar(-1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash = prime * hash + Arrays.hashCode(components);

        return hash;
    }
}