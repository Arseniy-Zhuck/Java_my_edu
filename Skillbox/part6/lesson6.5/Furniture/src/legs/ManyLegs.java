package legs;

import materia.HardMateria;
import materia.MaterialDetails;

public class ManyLegs extends Legs{
    public ManyLegs(int count, HardMateria materia, MaterialDetails materialDetails, boolean hollow, double thickness, double height) {
        super(count, materia, materialDetails, hollow, thickness, height);
    }

    @Override
    public String getDefinition() {
        return "Here we have" + getCount() + " legs" + getMaterials();
    }
}
