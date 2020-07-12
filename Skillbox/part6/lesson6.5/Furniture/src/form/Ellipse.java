package form;

public class Ellipse implements Form{
    private double x,y;

    public Ellipse(double x, double y) {
        setX(x);
        setY(y);
    }

    void setX(double x) {
        this.x = x;
    }

    void setY(double y) {
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    @Override
    public double getArea() {
        return Math.PI * x * y;
    }

    @Override
    public double getPerimeter() {
        return 4 * (Math.PI * x * y + Math.abs(x - y)) / (x + y);
    }

    @Override
    public String getSizes() {
        return String.format("Ellipse with big half shaft %g and small half shaft %g",
                Math.max(getX(),getY()), Math.min(getX(), getY()));
    }
}
