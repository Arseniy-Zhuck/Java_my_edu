package back;

import plate.Plate;
import plate.SinglePlate;

import java.util.ArrayList;

public class EmptyBackWithPlates extends Back{
    private ArrayList<Plate> plates;

    public EmptyBackWithPlates(boolean movable, double corner, Plate plate, double height) {
        super(movable, corner, true, plate, height);
        plates = new ArrayList<>();
    }

    public void addPlate(Plate plate) {
        plates.add(plate);
    }

    @Override
    public String getDefinition() {
        String s = super.getDefinition();
        s += "\nthe back is empty and has plates";
        for (Plate plate : plates) s += "\n" + plate.getDefinition();
        return s;
    }
}
