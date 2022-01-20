package oop.shchetinin.range.Range_main;

import oop.shchetinin.range.Range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");
        double userNumber = scanner.nextDouble();

        Range range1 = new Range(5, 2);

        System.out.println("Объект range1");
        System.out.println("Начало range1: " + range1.getFrom());
        System.out.println();

        System.out.println("Конец range1: " + range1.getTo());
        System.out.println();

        range1.setFrom(3);
        System.out.println("Начало range1 после изменения с помощью сеттера: " + range1.getFrom());
        System.out.println();

        System.out.println("Длина диапазона range1: " + range1.getLength());
        System.out.println();

        System.out.println("Введеное число принадлежит диапазону range1: " + range1.isInside(userNumber));
        System.out.println();

        Range range2 = new Range(1, 6);

        System.out.println("Объект range2");
        System.out.println("Длина диапазона range2: " + range2.getLength());
        System.out.println();

        System.out.println("Введеное число принадлежит диапазону range2: " + range2.isInside(userNumber));
        System.out.println();

        System.out.println("Начало range2: " + range2.getFrom());
        System.out.println();

        System.out.println("Конец range2: " + range2.getTo());
        System.out.println();

        range2.setTo(3);
        System.out.println("Конец range2 после изменения с помощью сеттера: " + range2.getTo());
    }
}