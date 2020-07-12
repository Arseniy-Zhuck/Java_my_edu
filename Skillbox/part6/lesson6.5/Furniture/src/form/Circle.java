package form;

public class Circle extends Ellipse {
    public Circle(double radius) {
        super(radius, radius);
    }

    double getRadius() {
        return getX();
    }

    void setRadius(double radius) {
        setX(radius);
        setY(radius);
    }

    @Override
    public String getSizes() {
        return "Circle with radius " + getRadius();
    }
}
