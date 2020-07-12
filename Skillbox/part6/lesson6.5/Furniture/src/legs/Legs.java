package legs;

import materia.HardMateria;
import materia.MaterialDetails;

public abstract class Legs {
    protected int count;
    protected HardMateria materia;
    protected MaterialDetails materialDetails;
    protected boolean hollow;
    protected double thickness;
    protected double height;

    protected int getCount() {
        return count;
    }

    protected void setCount(int count) {
        this.count = count;
    }

    protected HardMateria getMateria() {
        return materia;
    }

    protected void setMateria(HardMateria materia) {
        this.materia = materia;
    }

    protected MaterialDetails getMaterialDetails() {
        return materialDetails;
    }

    protected void setMaterialDetails(MaterialDetails materialDetails) {
        this.materialDetails = materialDetails;
    }

    protected boolean isHollow() {
        return hollow;
    }

    protected void setHollow(boolean hollow) {
        this.hollow = hollow;
    }

    protected double getThickness() {
        return thickness;
    }

    protected void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public double getHeight() {
        return height;
    }

    protected void setHeight(double height) {
        this.height = height;
    }

    public Legs(int count, HardMateria materia, MaterialDetails materialDetails,
                boolean hollow, double thickness, double height) {
        setCount(count);
        setHeight(height);
        setHollow(hollow);
        setMateria(materia);
        setMaterialDetails(materialDetails);
        setThickness(thickness);
    }

    public String getHeightString() {
        return String.valueOf(getHeight());
    }

    public abstract String getDefinition();

    protected String getMaterials() {
        return " made of " + materia.toString() + ": " + materialDetails.toString();
    }


}
