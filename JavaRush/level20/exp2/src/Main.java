import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> a;
        LinkedList<String> b = new LinkedList<>();
        ArrayList<String> c;
        a = b;
        c = (ArrayList<String>) a;
    }
}
