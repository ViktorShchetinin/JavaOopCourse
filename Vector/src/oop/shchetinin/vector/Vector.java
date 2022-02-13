package oop.shchetinin.vector;

import java.util.Arrays;

public class Vector {
    private final int n;
    private final double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0, n = " + n);
        }

        this.n = n;

        this.components = new double[n + 1];

        for (int i = 0; i < n + 1; i++) {
            this.components[i] = 0;
        }
    }

    public Vector(double[] components) {
        if (components == null) {
            throw new NullPointerException("components must be not null!");
        }

        this.components = new double[components.length];

        System.arraycopy(components, 0, this.components, 0, components.length);

        n = components.length - 1;

        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0, n = " + n);
        }
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0, n = " + n);
        }

        if (components == null) {
            throw new NullPointerException("components must be not null!");
        }

        this.n = n;

        this.components = new double[n + 1];

        for (int i = 0; i < n + 1; i++) {
            if (i < components.length) {
                this.components[i] = components[i];
            } else {
                this.components[i] = 0;
            }
        }
    }

    public Vector(Vector vector) {
        this.n = vector.n;
        this.components = vector.components;
    }

    public int getSize() {
        return n;
    }

    @Override
    public String toString() {
        if (components == null || components.length == 0) {
            return "{}";
        }

        if (components.length == 1) {
            return "{ " + components[0] + " }";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < components.length; i++) {
            if (i == 0) {
                sb.append("{ ")
                        .append(components[i])
                        .append(", ");
            } else if (i < components.length - 1) {
                sb.append(components[i])
                        .append(", ");
            } else {
                sb.append(components[i])
                        .append(" }");
            }
        }

        return sb.toString();
    }

    public Vector getSum(Vector vector) {
        int max = Math.max(components.length, vector.components.length);

        double[] resultComponents = new double[max];

        for (int i = 0; i < max; i++) {
            if (i >= vector.components.length) {
                resultComponents[i] = components[i];
            } else if (i >= components.length) {
                resultComponents[i] = vector.components[i];
            } else {
                resultComponents[i] = components[i] + vector.components[i];
            }
        }

        return new Vector(resultComponents);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        int max = Math.max(vector1.components.length, vector2.components.length);

        double[] resultComponents = new double[max];

        for (int i = 0; i < max; i++) {
            if (i >= vector1.components.length) {
                resultComponents[i] = vector2.components[i];
            } else if (i >= vector2.components.length) {
                resultComponents[i] = vector1.components[i];
            } else {
                resultComponents[i] = vector1.components[i] + vector2.components[i];
            }
        }

        return new Vector(resultComponents);
    }

    public Vector getDifference(Vector vector) {
        int max = Math.max(components.length, vector.components.length);

        double[] resultComponents = new double[max];

        for (int i = 0; i < max; i++) {
            if (i >= vector.components.length) {
                resultComponents[i] = components[i];
            } else if (i >= components.length) {
                resultComponents[i] = vector.components[i];
            } else {
                resultComponents[i] = components[i] - vector.components[i];
            }
        }

        return new Vector(resultComponents);
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        int max = Math.max(vector1.components.length, vector2.components.length);

        double[] resultComponents = new double[max];

        for (int i = 0; i < max; i++) {
            if (i >= vector1.components.length) {
                resultComponents[i] = vector2.components[i];
            } else if (i >= vector2.components.length) {
                resultComponents[i] = vector1.components[i];
            } else {
                resultComponents[i] = vector1.components[i] - vector2.components[i];
            }
        }

        return new Vector(resultComponents);
    }

    public static double getMultiple(Vector vector1, Vector vector2) {
        int max = Math.max(vector1.components.length, vector2.components.length);

        double result = 0;

        for (int i = 0; i < max; i++) {
            if (i >= vector1.components.length) {
                result += 0;
            } else if (i >= vector2.components.length) {
                result += 0;
            } else {
                result+= vector1.components[i] * vector2.components[i];
            }
        }

        return result;
    }

    public Vector getMultiplyVectorByScalar(double scalar) {
        double[] resultComponents = new double[components.length];

        for (int i = 0; i < resultComponents.length; i++) {
            resultComponents[i] = components[i] * scalar;
        }

        return new Vector(resultComponents);
    }

    public Vector getVectorReverse() {
        double[] resultComponents = new double[components.length];

        for (int i = 0; i < resultComponents.length; i++) {
            if (components[i] != 0) {
                resultComponents[i] = components[i] * -1;
            } else {
                break;
            }
        }

        return new Vector(resultComponents);
    }

    public int getVectorLength() {
        return components.length;
    }

    public void installComponentByIndex(double component, int index) {
        components[index] = component;
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

        return n == vector.n && Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash = prime * hash + Double.hashCode(n);
        hash = prime * hash + Arrays.hashCode(components);

        return hash;
    }
}