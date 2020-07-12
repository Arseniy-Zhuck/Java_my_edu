package form;

public class Trapezoid implements Form {
    private double bigFound;
    private double smallFound;
    private double height;

    double getAlpha() {
        return Math.atan(height / ((bigFound - smallFound) / 2));
    }

    public Trapezoid(double bigFound, double smallFound, double height) {
        setBigFound(bigFound);
        setHeight(height);
        setSmallFound(smallFound);
    }

    @Override
    public double getArea() {
        return (smallFound + bigFound) * height / 2;
    }

    @Override
    public double getPerimeter() {
        return smallFound + bigFound +
                2 * Math.sqrt(height * height + ((bigFound - smallFound) / 2) * ((bigFound - smallFound) / 2));
    }

    @Override
    public String getSizes() {
        return String.format("Trapezoid with big found %g, small found %g and height %g",
                getBigFound(), getSmallFound(), getHeight());
    }

    double getBigFound() {
        return bigFound;
    }

    void setBigFound(double bigFound) {
        this.bigFound = bigFound;
    }

    double getSmallFound() {
        return smallFound;
    }

    void setSmallFound(double smallFound) {
        this.smallFound = smallFound;
    }

    double getHeight() {
        return height;
    }

    void setHeight(double height) {
        this.height = height;
    }
}
