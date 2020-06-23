import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        double x = Double.parseDouble((new BufferedReader(new InputStreamReader(System.in))).readLine());
        System.out.println(method(x));
    }

    public static double method(double x) {
        return sqrt(x);
    }

    public static double sqrt(double x){
        IllegalArgumentException ill = new IllegalArgumentException();
        if (x<0) {
            System.out.println(ill.getStackTrace()[1]);
            throw ill;
        } else return Math.sqrt(x);
    }
}
