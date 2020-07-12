package back;

import plate.Plate;

public abstract class Back {
    private boolean movable;
    private double corner;
    private boolean empty;
    private Plate plate;
    private double height;

    public String getDefinition() {
        return String.format("The %s back has %g mm height, under %g corner with main carcas %s",
                isMovableString(), getHeight(), getCorner(), plate.getDefinition());
    }

    protected String isMovableString() {
        return isMovable() ? "movable" : "fixed";
    }

    public String getHeightString() {
        return String.valueOf(getHeight());
    }

    protected double getHeight() {
        return height;
    }

    protected Back(boolean movable, double corner, boolean empty, Plate plate, double height) {
        setCorner(corner);
        setEmpty(empty);
        setMovable(movable);
        setPlate(plate);
        setHeight(height);
    }

    protected boolean isMovable() {
        return movable;
    }

    protected void setMovable(boolean movable) {
        this.movable = movable;
    }

    protected double getCorner() {
        return corner;
    }

    public void setCorner(double corner) {
        this.corner = corner;
    }

    protected boolean isEmpty() {
        return empty;
    }

    protected void setEmpty(boolean empty) {
        this.empty = empty;
    }

    protected Plate getPlate() {
        return plate;
    }

    protected void setPlate(Plate plate) {
        this.plate = plate;
    }

    protected void setHeight(double height) {
        this.height = height;
    }
}
