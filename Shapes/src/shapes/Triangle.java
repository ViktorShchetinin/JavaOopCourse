package shapes;

public class Triangle implements Shape, Comparable<Shape> {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;
    private final double epsilon = 1e-09;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getSide(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2));
    }

    @Override
    public double getWidth() {
        if (Math.abs((x3 - x1) * (y2 - y1) - (y3 - y1) * (x2 - x1)) < epsilon) {
            return 0;
        }

        return Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.min(y2, y3));
    }

    @Override
    public double getHeight() {
        if (Math.abs((x3 - x1) * (y2 - y1) - (y3 - y1) * (x2 - x1)) < epsilon) {
            return 0;
        }

        return Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3));
    }

    @Override
    public double getArea() {
        if (Math.abs((x3 - x1) * (y2 - y1) - (y3 - y1) * (x2 - x1)) < epsilon) {
            return 0;
        }

        double triangleSemiPerimeter = (getSide(x1, y1, x2, y2) + getSide(x2, y2, x3, y3) + getSide(x1, y1, x3, y3)) / 2;

        return Math.sqrt(triangleSemiPerimeter * (triangleSemiPerimeter - getSide(x1, y1, x2, y2)) *
                (triangleSemiPerimeter - getSide(x2, y2, x3, y3)) * (triangleSemiPerimeter - getSide(x1, y1, x3, y3)));
    }

    @Override
    public double getPerimeter() {
        return getSide(x1, y1, x2, y2) + getSide(x2, y2, x3, y3) + getSide(x1, y1, x3, y3);
    }

    @Override
    public int compareTo(Shape o) {
        return (int) (this.getArea() - o.getArea());
    }

    @Override
    public String toString() {
        return "(Треугольник, площадь: " + getArea() + ", периметр: " + +getPerimeter() + ")";
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) o;

        return x1 == triangle.x1 && x2 == triangle.x2 && x3 == triangle.x3 &&
                y1 == triangle.y1 && y2 == triangle.y2 && y3 == triangle.y3;
    }
}