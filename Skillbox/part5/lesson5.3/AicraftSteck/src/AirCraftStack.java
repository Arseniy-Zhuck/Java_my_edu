import java.util.ArrayList;

public class AirCraftStack {
    private final int maxPlanes;
    private ArrayList<String> aircrafts;

    public AirCraftStack(int maxPlanes) {
        this.maxPlanes = maxPlanes;
        aircrafts = new ArrayList<>();
    }

    public void pushAirCruft(String aircraft) {
        aircrafts.add(aircraft);
    }

    public boolean checkForFree() {
        return (aircrafts.size()<maxPlanes);
    }

    public boolean isEmpty() {
        return aircrafts.isEmpty();
    }

    public String popAircraft() {
        return aircrafts.remove(aircrafts.size() - 1);
    }

    public ArrayList<String> popAllAircrafts() {
        ArrayList<String> result = new ArrayList<>();
        while (!isEmpty()) {
            result.add(aircrafts.remove(aircrafts.size() - 1));
        }
        return result;
    }

}
