package oop.shchetinin.vector_main;

import oop.shchetinin.vector.Vector;

public class Main {
    public static void main(String[] args) {
        try {
            double[] components = {1, 5, 6, 6, 8};
            Vector vector = new Vector(0, components);
            System.out.println(vector);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println(1);
        } finally {
            System.out.println("OK");
            System.out.println();
        }

        double[] components = {1, 5, 6, 6, 8};
        Vector vector = new Vector(7, components);
        Vector vectorClone = new Vector(vector);
        System.out.println("vector: " + vectorClone);
        System.out.println(vectorClone.getSize());
        System.out.println();

        Vector vector1 = new Vector(5);
        Vector vector1Clone = new Vector(vector1);
        System.out.println("vector1: " + vector1Clone);
        System.out.println(vector1Clone.getSize());
        System.out.println();

        Vector sumVector = vectorClone.getSum(vector1Clone);
        System.out.println("SUM: " + sumVector);
        System.out.println("SIZE: " + sumVector.getSize());
        System.out.println();

        Vector difVector = vector1Clone.getDifference(vectorClone);
        System.out.println("DIFFERENCE: " + difVector);
        System.out.println();

        Vector multiplyVectorByScalar = vectorClone.getMultiplyVectorByScalar(2);
        System.out.println("MULTIPLY VECTOR BY SCALAR: " + multiplyVectorByScalar);
        System.out.println();

        Vector reversedVector = vectorClone.getVectorReverse();
        System.out.println("REVERSE: " + reversedVector);
        System.out.println();

        System.out.println("Vector vectorClone length: " + vectorClone.getVectorLength());
        System.out.println();

        vector1Clone.installComponentByIndex(5.0, 3);
        vector1Clone.installComponentByIndex(2.0, 4);
        System.out.println("vector1: " + vector1Clone);
        System.out.println();

        System.out.println(vector1Clone.equals(new Vector(5)));
        System.out.println();

        System.out.println("SUM: " + Vector.getSum(vector1Clone, vectorClone));
        System.out.println();

        System.out.println("DIFFERENCE: " + Vector.getDifference(vectorClone, vector1Clone));
        System.out.println();

        System.out.println("SCALAR MULTIPLE: " + Vector.getMultiple(vector1Clone, vector1Clone));
        System.out.println();
    }
}