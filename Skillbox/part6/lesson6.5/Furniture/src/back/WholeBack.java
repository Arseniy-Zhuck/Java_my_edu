package back;

import plate.Plate;

public class WholeBack extends Back{
    public WholeBack(boolean movable, double corner, Plate plate, double height) {
        super(movable, corner, false, plate, height);
    }

    @Override
    public String getDefinition() {
        return super.getDefinition() + "the back is whole";
    }

}
