package legs;

import materia.HardMateria;
import materia.MaterialDetails;

public abstract class SingleLeg extends Legs{

    private double thicknessSupport;

    public SingleLeg(HardMateria materia, MaterialDetails materialDetails,
                     boolean hollow, double thickness, double height, double thicknessSupport) {
        super(1, materia, materialDetails, hollow, thickness, height);
        setThicknessSupport(thicknessSupport);
    }

    protected double getThicknessSupport() {
        return thicknessSupport;
    }

    protected void setThicknessSupport(double thicknessSupport) {
        this.thicknessSupport = thicknessSupport;
    }
}
