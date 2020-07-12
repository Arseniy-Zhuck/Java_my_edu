package legs;

import materia.HardMateria;
import materia.MaterialDetails;

public class SingleLegLegs extends SingleLeg {
    private int addLegCount;
    private boolean wheels;
    private double width;
    private boolean flat;

    int getAddLegCount() {
        return addLegCount;
    }

    void setAddLegCount(int addLegCount) {
        this.addLegCount = addLegCount;
    }

    boolean hasWheels() {
        return wheels;
    }

    void setWheels(boolean wheels) {
        this.wheels = wheels;
    }

    public SingleLegLegs(   int addLegCount, boolean wheels, double width, boolean flat,
                            HardMateria materia, MaterialDetails materialDetails,
                            boolean hollow, double thickness, double height, double thicknessSupport) {
        super(materia, materialDetails, hollow, thickness, height, thicknessSupport);
        setAddLegCount(addLegCount);
        setFlat(flat);
        setWheels(wheels);
        setWidth(width);

    }

    @Override
    public String getDefinition() {
        String s = "Here we have one leg" + getMaterials() + "with " + getAddLegCount() +  " low legs";
        if (hasWheels()) s+= " with wheels";
        if (flat) s+= "flat on the floor";
        return s;
    }

    double getWidth() {
        return width;
    }

    void setWidth(double width) {
        this.width = width;
    }

    boolean isFlat() {
        return flat;
    }

    void setFlat(boolean flat) {
        this.flat = flat;
    }
}
