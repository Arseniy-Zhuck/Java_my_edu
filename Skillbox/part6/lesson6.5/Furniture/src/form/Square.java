package form;

public class Square extends Rectangle {
    //private double size;

    public Square(double size) {
        super(size, size);
    }

    double getSize() {
        return getLength();
    }

    void setSize(double size) {
        //this.size = size;
        setLength(size);
        setWidth(size);
    }

    @Override
    public String getSizes() {
        return "Square with size " + getSize();
    }
}
