package shapes;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double sideWidth, double sideHeight) {
        this.width = sideWidth;
        this.height = sideHeight;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return "(Прямоугольник, ширина: " + width + ", высота: " + height + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);

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

        return width == rectangle.width && height == rectangle.height;
    }
}