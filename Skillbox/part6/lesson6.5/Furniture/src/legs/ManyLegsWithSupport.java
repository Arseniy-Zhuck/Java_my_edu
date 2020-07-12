package legs;

import materia.HardMateria;
import materia.MaterialDetails;
import plate.Plate;
import plate.SinglePlate;

import java.util.ArrayList;

public class ManyLegsWithSupport extends Legs{
    private ManyLegs legs;
    private ArrayList<SinglePlate> support;


    public ManyLegsWithSupport(int count, HardMateria materia, MaterialDetails materialDetails, boolean hollow, double thickness, double height) {
        super(count, materia, materialDetails, hollow, thickness, height);
        support = new ArrayList<>();
    }

    public void establishSupport(SinglePlate singleSupport) {
        support.add(singleSupport);
    }

    @Override
    public String getDefinition() {
        String s = legs.getDefinition();
        for (SinglePlate plate : support) s+=(" with support " + plate.getDefinition());
        return s;
    }
}
