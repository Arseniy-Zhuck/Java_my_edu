import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {

    public static boolean isPowerOfTwo(int value) {
        return (Math.abs(value)>0)&&(Integer.highestOneBit(Math.abs(value))==Integer.lowestOneBit(Math.abs(value)));

    }

    public static void main(String[] args) throws IOException {
        int val = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
        System.out.println(isPowerOfTwo(val));
    }
}
