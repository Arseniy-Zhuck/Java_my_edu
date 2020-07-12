package dinigRoomFurniture;

import legs.Legs;
import plate.Plate;

public class Stool extends DiningRoomFurniture{

    public static Stool getWholeStool(Legs legs, Plate plate) {
        return new Stool(legs, plate, true);
    }

    public static Stool getConstructedStool(Legs legs, Plate plate) {
        return new Stool(legs, plate, false);
    }

    private Stool(Legs legs, Plate plate, boolean legsAndPlate) {
        super(legs, plate, legsAndPlate);
    }

    @Override
    public String definition() {
        String s = "This stool is very good\n It's";
        s+= (isConstructed() + "\n");
        s+= (getLegs().getDefinition() + "\n");
        s+= (getPlate().getDefinition());
        return s;
    }

    @Override
    public String sizes() {
        String s = " ";
        s += "The plate is" + getPlate().getFormDefinition() +" and height is "+ getPlate().getHeight();
        s += "The stool itself is " + getLegs().getHeight();
        return s;
    }

    @Override
    public String connection() {
        return isConstructed();
    }
}
