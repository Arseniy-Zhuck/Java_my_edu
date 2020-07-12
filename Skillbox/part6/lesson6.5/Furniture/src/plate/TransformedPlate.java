package plate;

import form.Form;

public class TransformedPlate implements Plate{
    private Plate plate;
    private Form doubleForm;
    private static final String TRANSFORMED_TO = " can be transformed to ";

    public TransformedPlate(Plate plate, Form doubleForm) {
        setPlate(plate);
        setDoubleForm(doubleForm);
    }

    Plate getPlate() {
        return plate;
    }

    void setPlate(Plate plate) {
        this.plate = plate;
    }

    Form getDoubleForm() {
        return doubleForm;
    }

    void setDoubleForm(Form doubleForm) {
        this.doubleForm = doubleForm;
    }

    @Override
    public String getDefinition() {
        return plate.getDefinition() + TRANSFORMED_TO + doubleForm.getSizes() ;
    }

    @Override
    public double getHeight() {
        return plate.getHeight() / 2;
    }

    @Override
    public String getMaterials() {
        return plate.getMaterials();
    }

    @Override
    public String getFormDefinition() {
        return plate.getFormDefinition() + TRANSFORMED_TO + doubleForm.getSizes();
    }
}
