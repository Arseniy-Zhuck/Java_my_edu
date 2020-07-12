package plate;

import materia.MaterialDetails;
import materia.SoftMateria;
import materia.Upholstery;

public class UpholsteredPlate implements Plate{
    private Plate plate;
    private SoftMateria softMateria;
    private Upholstery upholstery;
    private MaterialDetails upholsteryDetails;
    private double softMateriaHeight;
    private static final String UPHOLSTER = " UPHOLSTERED WITH ";
    private static final String SOFT = " SOFTED with";

    Plate getPlate() {
        return plate;
    }

    void setPlate(Plate plate) {
        this.plate = plate;
    }

    SoftMateria getSoftMateria() {
        return softMateria;
    }

    void setSoftMateria(SoftMateria softMateria) {
        this.softMateria = softMateria;
    }

    Upholstery getUpholstery() {
        return upholstery;
    }

    void setUpholstery(Upholstery upholstery) {
        this.upholstery = upholstery;
    }

    MaterialDetails getUpholsteryDetails() {
        return upholsteryDetails;
    }

    void setUpholsteryDetails(MaterialDetails upholsteryDetails) {
        this.upholsteryDetails = upholsteryDetails;
    }

    public UpholsteredPlate(Plate plate, SoftMateria softMateria, Upholstery upholstery,
                            MaterialDetails upholsteryDetails, double softMateriaHeight) {
        setPlate(plate);
        setSoftMateria(softMateria);
        setUpholstery(upholstery);
        setUpholsteryDetails(upholsteryDetails);
        setSoftMateriaHeight(softMateriaHeight);
    }

    @Override
    public String getDefinition() {
        return plate.getDefinition() + UPHOLSTER + upholstery.toString() + ": " + upholsteryDetails +
                SOFT + softMateria.toString();
    }

    @Override
    public double getHeight() {
        return plate.getHeight() + getSoftMateriaHeight();
    }

    @Override
    public String getMaterials() {
        return plate.getMaterials() + " " + upholstery.toString() + ": " + upholsteryDetails + softMateria.toString();
    }

    @Override
    public String getFormDefinition() {
        return plate.getFormDefinition();
    }

    double getSoftMateriaHeight() {
        return softMateriaHeight;
    }

    void setSoftMateriaHeight(double softMateriaHeight) {
        this.softMateriaHeight = softMateriaHeight;
    }
}
