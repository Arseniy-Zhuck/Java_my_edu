package plate;

import form.*;


public interface Plate {
    default String getDefinition() {
        return String.format("Plate of form %s, height %g and material %s",
                getFormDefinition(), getHeight(), getMaterials());
    }
    double getHeight();
    String getMaterials();
    String getFormDefinition();
}
