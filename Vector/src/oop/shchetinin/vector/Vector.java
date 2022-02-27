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

    public double[] getComponents() {
        return components;
    }

    public void setComponents(double[] components) {
        this.components = components;
    }

    public int getSize() {
        return components.length;
    }

    public double getLength() {
        return components.length;
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

    public void getSum(Vector vector) {
        int max = Math.max(components.length, vector.components.length);

        double[] tmp = new double[max];

        for (int i = 0; i < max; i++) {
            if (i >= vector.components.length) {
                tmp[i] = components[i];
            } else if (i >= components.length) {
                tmp[i] = vector.components[i];
            } else {
                tmp[i] = components[i] + vector.components[i];
            }
        }

        components = Arrays.copyOf(tmp, tmp.length);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        vector1.getSum(vector2);

        return vector1;
    }

    public void getDifference(Vector vector) {
        int max = Math.max(components.length, vector.components.length);

        double[] tmp = new double[max];

        for (int i = 0; i < max; i++) {
            if (i >= vector.components.length) {
                tmp[i] = components[i];
            } else if (i >= components.length) {
                tmp[i] = vector.components[i];
            } else {
                tmp[i] = components[i] - vector.components[i];
            }
        }

        components = Arrays.copyOf(tmp, tmp.length);
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        vector1.getDifference(vector2);

        return vector1;
    }

    public static double getScalarMultiple(Vector vector1, Vector vector2) {
        int max = Math.max(vector1.components.length, vector2.components.length);

        double result = 0;

        for (int i = 0; i < max; i++) {
            result += vector1.components[i] * vector2.components[i];
        }

        return result;
    }

    public void multiplyByScalar(int scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] * scalar;
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