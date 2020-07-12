package form;

public class Rectangle extends Trapezoid {
    //private double length, width;

    public Rectangle(double length, double width) {
        super(length, length, width);
    }

    @Override
    double getAlpha() {
        return Math.PI / 2;
    }

    void setWidth(double width) {
        setHeight(width);
    }

    void setLength(double length) {
        setBigFound(length);
        setSmallFound(length);
        //this.length = length;
    }

    double getLength() {
        return getBigFound();
    }

    double getWidth() {
        return getHeight();
    }

    @Override
    public String getSizes() {
        return String.format("Rectangle with sizes %g and %g", getLength(),getWidth());
    }
}
