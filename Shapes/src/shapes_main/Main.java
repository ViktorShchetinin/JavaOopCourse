package shapes_main;

import shapes.*;

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
        if (shapesArray.length == 0) {
            return null;
        }

        Arrays.sort(shapesArray, new PerimeterComparator());
        return shapesArray[shapesArray.length - 2];
    }

    public static void main(String[] args) {
        Shape square = new Square(5);
        Shape square1 = new Square(5);
        System.out.println("Результат сравнения двух квадратов " + square + " и "
                + square1 + ": " + square.equals(square1));

        System.out.println("Ширина квадрата: " + square.getWidth());
        System.out.println("Высота квадрата: " + square.getHeight());
        System.out.println("Площадь квадрата: " + square.getArea());
        System.out.println("Периметр квадрата: " + square.getPerimeter());
        System.out.println();

        Shape rectangle = new Rectangle(5, 2);

        System.out.println("Ширина прямоугольника: " + rectangle.getWidth());
        System.out.println("Высота прямоугольника: " + rectangle.getHeight());
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());
        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeter());
        System.out.println();

        Shape triangle = new Triangle(1, 1, 1, 9, 9, 9);

        System.out.println(triangle);
        System.out.println("Ширина треугольника: " + triangle.getWidth());
        System.out.println("Координаты: (" + ((Triangle) triangle).getX1() + ", " + ((Triangle) triangle).getY1() + "), ("
                + ((Triangle) triangle).getX2() + ", " + ((Triangle) triangle).getY2() + "), "
                + ((Triangle) triangle).getX3() + ", " + ((Triangle) triangle).getY3() + ")");
        System.out.println("Высота треугольника: " + triangle.getHeight());
        System.out.println("Площадь треугольника: " + triangle.getArea());
        System.out.println("Периметр треугольника: " + triangle.getPerimeter());
        System.out.println();

        Shape circle = new Circle(10);

        System.out.println("Ширина круга: " + ((Circle) circle).getRadius());
        System.out.println("Ширина круга: " + circle.getWidth());
        System.out.println("Высота круга: " + circle.getHeight());
        System.out.println("Площадь круга: " + circle.getArea());
        System.out.println("Периметр круга: " + circle.getPerimeter());
        System.out.println();

        Shape[] shapesArray = {circle, new Circle(3), square, new Square(100), triangle, rectangle};

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