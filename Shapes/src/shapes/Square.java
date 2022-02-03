package shapes;

public class Square implements Shape, Comparable<Shape> {
    private final double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }

    public int compareTo(Shape o) {
        return (int) (this.getArea() - o.getArea());
    }

    @Override
    public String toString() {
        return "(Квадрат, площадь: " + getArea() + ", периметр: " + +getPerimeter() + ")";
    }

    @Override
    public int hashCode() {
        return Double.hashCode(sideLength);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Square square = (Square) o;

        return sideLength == square.sideLength;
    }
}