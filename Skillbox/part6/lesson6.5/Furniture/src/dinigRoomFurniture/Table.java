package dinigRoomFurniture;

import legs.Legs;
import plate.Plate;

public class Table extends DiningRoomFurniture {

    public static Table getWholeTable(Legs legs, Plate plate) {
        return new Table(legs, plate, true);
    }

    public static Table getConstructedTable(Legs legs, Plate plate) {
        return new Table(legs, plate, false);
    }

    private Table(Legs legs, Plate plate, boolean legsAndPlate) {
        super(legs, plate, legsAndPlate);
    }

    @Override
    public String definition() {
        String s = "This table is very good\n It's";
        s+= (isConstructed() + "\n");
        s+= (getLegs().getDefinition() + "\n");
        s+= (getPlate().getDefinition());
        return s;
    }

    @Override
    public String sizes() {
        String s = " ";
        s += "The plate is" + getPlate().getFormDefinition() +" and height is "+ getPlate().getHeight();
        s += "The table itself is " + getPlate().getHeight();
        return s;
    }

    @Override
    public String connection() {
        return isConstructed();
    }
}
