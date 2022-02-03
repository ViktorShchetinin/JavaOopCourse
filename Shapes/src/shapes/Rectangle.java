package shapes;

public class Rectangle implements Shape, Comparable<Shape>{
    private final double sideWidth;
    private final double sideHeight;

    public Rectangle(double sideWidth, double sideHeight) {
        this.sideWidth = sideWidth;
        this.sideHeight = sideHeight;
    }

    @Override
    public double getWidth() {
        return sideWidth;
    }

    @Override
    public double getHeight() {
        return sideHeight;
    }

    @Override
    public double getArea() {
        return sideWidth * sideHeight;
    }

    @Override
    public double getPerimeter() {
        return (sideWidth + sideHeight) * 2;
    }

    public int compareTo(Shape o) {
        return (int) (this.getArea() - o.getArea());
    }

    @Override
    public String toString() {
        return "(Прямоугольник, площадь: " + getArea() + ", периметр: " + +getPerimeter() + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + Double.hashCode(sideWidth);
        hash = prime * hash + Double.hashCode(sideHeight);
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

        Rectangle rectangle = (Rectangle) o;

        return sideWidth == rectangle.sideWidth && sideHeight == rectangle.sideHeight;
    }
}