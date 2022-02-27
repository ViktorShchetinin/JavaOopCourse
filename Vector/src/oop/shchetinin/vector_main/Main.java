package oop.shchetinin.vector_main;

import oop.shchetinin.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            double[] components = {1, 5, 6, 6, 8};
            Vector vector = new Vector(components);
            System.out.println(vector);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println(1);
        } finally {
            System.out.println("OK");
            System.out.println();
        }

        double[] components = {1, -5, -0.0, 6, 6, 8};
        Vector vector = new Vector(7, components);
        vector.setComponents(components);
        Vector vectorClone = new Vector(vector);
        System.out.println("vector: " + vectorClone);
        System.out.println(vectorClone.getSize());
        System.out.println();

        Vector vector1 = new Vector(5);
        Vector vector1Clone = new Vector(vector1);
        System.out.println("vector1: " + vector1Clone);
        System.out.println(vector1Clone.getSize());
        System.out.println();

        vectorClone.getSum(vector1Clone);
        System.out.println("SUM: " + vectorClone);
        System.out.println("SUM: " + Vector.getSum(vectorClone, vector1Clone));
        System.out.println();

        vector1Clone.getDifference(vectorClone);
        System.out.println("DIFFERENCE: " + vector1Clone);
        System.out.println();

        vectorClone.multiplyByScalar(2);
        System.out.println("MULTIPLY VECTOR BY SCALAR: " + vectorClone);
        System.out.println();

        vectorClone.reverse();
        System.out.println("REVERSE: " + vectorClone);
        System.out.println();

        System.out.println("Vector vectorClone length: " + vectorClone.getLength());
        System.out.println();

        vector1Clone.setComponentByIndex(3, 5.0);
        vector1Clone.setComponentByIndex(4, 2.0);
        System.out.println("vector1: " + vector1Clone);
        System.out.println();

        System.out.println(vector1Clone.equals(new Vector(5)));
        System.out.println();

        System.out.println("DIFFERENCE: " + Vector.getDifference(vectorClone, vector1Clone));
        System.out.println();

        System.out.println("SCALAR MULTIPLE: " + Vector.getScalarMultiple(vector1Clone, vectorClone));
        System.out.println();

        System.out.println(Arrays.toString(vector1Clone.getComponents()));
    }
}