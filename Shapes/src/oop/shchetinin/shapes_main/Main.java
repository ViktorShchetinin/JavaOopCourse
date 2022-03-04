package oop.shchetinin.shapes_main;

import oop.shchetinin.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shape getShapeWithMaxArea(Shape[] shapesArray) {
        if (shapesArray.length == 0) {
            return null;
        }

        Arrays.sort(shapesArray, new AreaComparator());
        return shapesArray[shapesArray.length - 1];
    }

    public static Shape getShapeWithSecondPerimeter(Shape[] shapesArray) {
        if (shapesArray.length <= 1) {
            return null;
        }

        Arrays.sort(shapesArray, new PerimeterComparator());
        return shapesArray[shapesArray.length - 2];
    }

    public static void main(String[] args) {
        Square square1 = new Square(5);
        Square square2 = new Square(5);
        System.out.println("Результат сравнения двух квадратов " + square1 + " и "
                + square2 + ": " + square1.equals(square2));

        square1.setSideLength(6);
        square2.setSideLength(6);

        System.out.println("Ширина квадрата: " + square1.getWidth());
        System.out.println("Высота квадрата: " + square1.getHeight());
        System.out.println("Длина стороны квадрата: " + square1.getSideLength());
        System.out.println("Площадь квадрата: " + square1.getArea());
        System.out.println("Периметр квадрата: " + square1.getPerimeter());
        System.out.println();

        Rectangle rectangle = new Rectangle(5, 2);

        rectangle.setWidth(6);
        rectangle.setHeight(3);

        System.out.println("Ширина прямоугольника: " + rectangle.getWidth
                ());
        System.out.println("Высота прямоугольника: " + rectangle.getHeight());
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());
        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeter());
        System.out.println();

        Triangle triangle = new Triangle(1, 1, 1, 9, 9, 9);

        triangle.setX1(2);
        triangle.setX2(2);
        triangle.setX3(2);
        triangle.setY1(10);
        triangle.setY2(10);
        triangle.setY3(10);

        System.out.println(triangle);
        System.out.println("Координаты: (" + triangle.getX1() + ", " + triangle.getY1() + "), ("
                + triangle.getX2() + ", " + triangle.getY2() + "), "
                + triangle.getX3() + ", " + triangle.getY3() + ")");
        System.out.println("Ширина треугольника: " + triangle.getWidth());
        System.out.println("Высота треугольника: " + triangle.getHeight());
        System.out.println("Площадь треугольника: " + triangle.getArea());
        System.out.println("Периметр треугольника: " + triangle.getPerimeter());
        System.out.println();

        Circle circle = new Circle(10);

        circle.setRadius(9);

        System.out.println("Ширина круга: " + circle.getRadius());
        System.out.println("Ширина круга: " + circle.getWidth());
        System.out.println("Высота круга: " + circle.getHeight());
        System.out.println("Площадь круга: " + circle.getArea());
        System.out.println("Периметр круга: " + circle.getPerimeter());
        System.out.println();

        Shape[] shapesArray = {circle, new Circle(3), square1, new Square(100), triangle, rectangle};

        Arrays.sort(shapesArray, new AreaComparator());
        System.out.println(Arrays.toString(shapesArray));
        System.out.println();

        System.out.println("Максимальная фигура по площади: " + getShapeWithMaxArea(shapesArray));
        System.out.println();

        Arrays.sort(shapesArray, new PerimeterComparator());
        System.out.println(Arrays.toString(shapesArray));
        System.out.println();

        System.out.println("Вторая фигура по периметру: " + getShapeWithSecondPerimeter(shapesArray));
    }
}