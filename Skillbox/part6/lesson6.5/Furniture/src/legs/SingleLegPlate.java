package legs;

import form.Form;
import materia.HardMateria;
import materia.MaterialDetails;
import plate.SinglePlate;

public class SingleLegPlate extends SingleLeg{
    private SinglePlate singlePlate;

    public SingleLegPlate(Form form,  HardMateria materia, MaterialDetails materialDetails,
                          boolean hollow, double thickness, double height, double thicknessSupport) {
        super(materia, materialDetails, hollow, thickness, height, thicknessSupport);
        setSinglePlate(new SinglePlate(form, thicknessSupport, materia, materialDetails));
    }

    public SinglePlate getSinglePlate() {
        return singlePlate;
    }

    public void setSinglePlate(SinglePlate singlePlate) {
        this.singlePlate = singlePlate;
    }

    @Override
    public String getDefinition() {
        return "We have platform " + singlePlate.getDefinition() + " and one leg";
    }
}
