package dinigRoomFurniture;

import legs.Legs;
import plate.Plate;

public abstract class DiningRoomFurniture {
    private Legs legs;
    private Plate plate;
    private boolean legsAndPlate;

    public abstract String definition();
    public abstract String sizes();
    public abstract String connection();

    protected String isConstructed() {
        return isLegsAndPlate() ? " whole " : " constructed ";
    }

    protected DiningRoomFurniture(Legs legs, Plate plate, boolean legsAndPlate) {
        setLegs(legs);
        setLegsAndPlate(legsAndPlate);
        setPlate(plate);
    }

    public Legs getLegs() {
        return legs;
    }

    public void setLegs(Legs legs) {
        this.legs = legs;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public boolean isLegsAndPlate() {
        return legsAndPlate;
    }

    public void setLegsAndPlate(boolean legsAndPlate) {
        this.legsAndPlate = legsAndPlate;
    }
}
