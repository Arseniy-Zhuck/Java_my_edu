package plate;

import form.Form;
import materia.*;

public class SinglePlate implements Plate {
    private Form form;
    private double height;
    private HardMateria materia;
    private MaterialDetails materialDetails;

    public SinglePlate(Form form, double height, HardMateria hardMateria, MaterialDetails materialDetails) {
        setForm(form);
        setHeight(height);
        setMateria(hardMateria);
        setMaterialDetails(materialDetails);
    }

    MaterialDetails getMaterialDetails() {
        return materialDetails;
    }

    void setMaterialDetails(MaterialDetails materialDetails) {
        this.materialDetails = materialDetails;
    }

    HardMateria getMateria() {
        return materia;
    }

    void setMateria(HardMateria materia) {
        this.materia = materia;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public String getMaterials() {
        return materia.toString() + ": " + materialDetails.toString();
    }

    void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String getFormDefinition() {
        return form.getSizes();
    }

    Form getForm() {
        return form;
    }

    void setForm(Form form) {
        this.form = form;
    }
}
