package form;

public class RoundCorners implements Form {
    private double radius;
    private Trapezoid trapezoid;

    public RoundCorners(double radius, Trapezoid trapezoid) {
        this.radius = radius;
        this.trapezoid = trapezoid;
    }

    private double getRadius() {
        return radius;
    }

    @Override
    public double getArea() { // из площади трапеции вычитаются закругленные края
                            // для прямоугольника формула такая же с учетом getAlpha() = 90 градусов
        return trapezoid.getArea() - 2 * (getRadius() * getRadius() * Math.tan((Math.PI - trapezoid.getAlpha()) / 2) -
                trapezoid.getAlpha() / 2 * getRadius() * getRadius() * Math.tan((Math.PI - trapezoid.getAlpha()) / 2) * Math.tan((Math.PI - trapezoid.getAlpha()) / 2)) -
                2 * (getRadius() * getRadius() * Math.tan(trapezoid.getAlpha() / 2) -
                        (Math.PI - trapezoid.getAlpha()) / 2 * getRadius() * getRadius() * Math.tan(trapezoid.getAlpha() / 2) * Math.tan(trapezoid.getAlpha() / 2));
    }

    @Override
    public double getPerimeter() { // из периметра вычитаем 2 радиуса закругругления и прибавляем длину дуги для каждого угла
        return trapezoid.getPerimeter() - 8 * getRadius() + 2 * getRadius() * trapezoid.getAlpha() + 2 * getRadius() * (Math.PI - trapezoid.getAlpha());
    }

    @Override
    public String getSizes() {
        return trapezoid.getSizes() + "with roundCorners with radius " + getRadius();
    }
}
