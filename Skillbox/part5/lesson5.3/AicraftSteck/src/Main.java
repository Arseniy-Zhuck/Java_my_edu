import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main {

    public static void printList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " is leaving");
        }
    }

    public static void main(String[] args) throws IOException {
        AirCraftStack aircraftParking = new AirCraftStack(5);
        System.out.println("Welcome to our Aircraft Parking");
        System.out.println("Please enter plane number \"XXX\" or command {exitAll, exitLast, quit}");
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            String s = bR.readLine();
            if (s.equals("quit")) break;
            if (s.equals("exitLast")) {
                if (aircraftParking.isEmpty()) System.out.println("There is no planes");
                else System.out.println(aircraftParking.popAircraft() + " is leaving");
                continue;
            }
            if (s.equals("exitAll")) {
                if (aircraftParking.isEmpty()) System.out.println("There is no planes");
                else printList(aircraftParking.popAllAircrafts());
                continue;
            }

            if (Pattern.compile("[0-9]{3}").matcher(s).matches()) {
                if (aircraftParking.checkForFree()) {
                    aircraftParking.pushAirCruft(s);
                    System.out.println("Aircraft " + s + " is now in the parking");
                } else System.out.println("Sorry, no free places");
            } else System.out.println("Wrong number, try again");
        }
    }
}
