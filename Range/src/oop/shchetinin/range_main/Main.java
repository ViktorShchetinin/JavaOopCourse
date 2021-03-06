package oop.shchetinin.range_main;

import oop.shchetinin.range.Range;

public class Main {
    public static void main(String[] args) {
        double number = 1;

        Range range1 = new Range(2, 5);

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

        System.out.println("Введенное число принадлежит диапазону range1: " + range1.isInside(number));
        System.out.println();

        Range range2 = new Range(1, 6);

        System.out.println("Объект range2");
        System.out.println("Длина диапазона range2: " + range2.getLength());
        System.out.println();

        System.out.println("Введенное число принадлежит диапазону range2: " + range2.isInside(number));
        System.out.println();

        System.out.println("Начало range2: " + range2.getFrom());
        System.out.println();

        System.out.println("Конец range2: " + range2.getTo());
        System.out.println();

        range2.setTo(3);
        System.out.println("Конец range2 после изменения с помощью сеттера: " + range2.getTo());
        System.out.println();

        Range range3 = new Range(3, 5);
        Range range4 = new Range(4, 6);

        System.out.println(range3);
        System.out.println(range4);

        System.out.println("Результат пересечения интервалов: " + range3.getIntersection(range4));

        System.out.println("Результат объединения интервалов: " +
                Range.toString(range3.getUnion(range4)));

        System.out.println("Результат разности первого и второго интервала: " +
                Range.toString(range3.getDifference(range4)));
    }
}