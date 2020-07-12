package dinigRoomFurniture;

import back.Back;
import legs.Legs;
import plate.Plate;

public class Chair extends DiningRoomFurniture{
    private Back back;
    private boolean plateAndBack;

    @Override
    public String definition() {
        String s = "This chair is very good\n It's";
        s+= (isConstructed() + "\n");
        s+= (getLegs().getDefinition() + "\n");
        s+= (getPlate().getDefinition());
        s+= getBack().getDefinition();
        s+= backIsConstructed();
        return s;
    }

    @Override
    public String sizes() {
        String s = " ";
        s += "The plate is" + getPlate().getFormDefinition() +" and height is "+ getPlate().getHeight() + "\n";
        s += "The legs are " + getLegs().getHeight() + ", the back is " + getBack().getHeightString();
        return s;
    }

    @Override
    public String connection() {
        return isConstructed() + backIsConstructed();
    }

    private String backIsConstructed() {
        return isPlateAndBack() ? "back is carcas" : "back is constructed";
    }

    public Chair(Legs legs, Plate plate, Back back, boolean legsAndPlate, boolean plateAndBack, Back Back) {
        super(legs, plate, legsAndPlate);
        setBack(back);
        setPlateAndBack(plateAndBack);
    }

    Back getBack() {
        return back;
    }

    void setBack(Back back) {
        this.back = back;
    }

    boolean isPlateAndBack() {
        return plateAndBack;
    }

    void setPlateAndBack(boolean plateAndBack) {
        this.plateAndBack = plateAndBack;
    }
}
