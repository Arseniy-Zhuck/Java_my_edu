import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void printSet(Set<String> set) {
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) System.out.println(iter.next());
    }


    public static void main(String[] args) throws IOException {
        System.out.println("Please, write medicine or command {LIST, EXIT}");
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        Set<String> medicines= new HashSet<>();
        for (;;) {
            String s = bR.readLine().trim();
            if (s.equals("EXIT")) break;
            if (s.equals("LIST")) {
                System.out.println("Whole list of midicines is:");
                printSet(medicines);
                continue;
            }
            medicines.add(s);
        }
    }
}
