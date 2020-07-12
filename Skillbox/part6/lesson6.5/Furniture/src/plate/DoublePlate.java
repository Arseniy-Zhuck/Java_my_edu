package plate;

import form.Form;
import materia.HardMateria;
import materia.MaterialDetails;

public class DoublePlate implements Plate{
    private Plate plate;
    private Plate doublePlate;
    private static final String ADD_PLATE = " with additional plate ";

    public DoublePlate(Plate plate, Form form, double addHeight, HardMateria addMateria, MaterialDetails addMaterialDetails) {
        setPlate(plate);
        setDoublePlate(new SinglePlate(form, addHeight, addMateria, addMaterialDetails));
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public Plate getDoublePlate() {
        return doublePlate;
    }

    public void setDoublePlate(Plate doublePlate) {
        this.doublePlate = doublePlate;
    }

    @Override
    public double getHeight() {
        return plate.getHeight() + doublePlate.getHeight();
    }

    @Override
    public String getMaterials() {
        return plate.getMaterials() + ADD_PLATE + doublePlate.getMaterials();
    }

    @Override
    public String getFormDefinition() {
        return plate.getFormDefinition() + ADD_PLATE + doublePlate.getFormDefinition();
    }
}
