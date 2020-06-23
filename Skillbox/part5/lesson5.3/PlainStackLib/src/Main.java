import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Pattern;

public class Main {
    public static final int MAX_PLANES = 5;

    public static boolean isFilled(Stack<String> aircrafts) {
        return aircrafts.size() == MAX_PLANES;
    }

    public static void popAll(Stack<String> aircrafts) {
        while (!aircrafts.empty()) {
            System.out.println(aircrafts.pop() + " is leaving");
        }
    }


    public static void main(String[] args) throws IOException {
        Stack<String> aircraftParking = new Stack<>();
        System.out.println("Welcome to our Aircraft Parking");
        System.out.println("Please enter plane number \"XXX\" or command {exitAll, exitLast, quit}");
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            String s = bR.readLine();
            if (s.equals("quit")) break;
            if (s.equals("exitLast")) {
                if (aircraftParking.isEmpty()) System.out.println("There is no planes");
                else System.out.println(aircraftParking.pop() + " is leaving");
                continue;
            }
            if (s.equals("exitAll")) {
                if (aircraftParking.isEmpty()) System.out.println("There is no planes");
                else popAll(aircraftParking);
                continue;
            }

            if (Pattern.compile("[0-9]{3}").matcher(s).matches()) {
                if (!isFilled(aircraftParking)) {
                    aircraftParking.push(s);
                    System.out.println("Aircraft " + s + " is now in the parking");
                } else System.out.println("Sorry, no free places");
            } else System.out.println("Wrong number, try again");
        }
    }
}
