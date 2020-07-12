package back;

import plate.Plate;
import plate.SinglePlate;

import java.util.ArrayList;

public class EmptyBackWithLines extends Back {
    private ArrayList<SinglePlate> plates;

    public EmptyBackWithLines(boolean movable, double corner, SinglePlate plate, double height) {
        super(movable, corner, true, plate, height);
        plates = new ArrayList<>();
    }

    public void addPlate(SinglePlate plate) {
        plates.add(plate);
    }

    @Override
    public String getDefinition() {
        String s = super.getDefinition();
        s += "\nthe back is empty and has additional empty carcases";
        for (SinglePlate plate : plates) s += "\n" + plate.getDefinition();
        return s;
    }
}
