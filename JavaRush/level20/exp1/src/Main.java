import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static long[] getNumbers(long N) {
        List<Long> list = new ArrayList<>();


        for (long i = 0; i < N; i++) {
            arm(i);
            if (arm(i) == i){
                list.add(i);
            }
        }
        long[] result = new long [list.size()];
        result = list.stream().mapToLong(l -> l).toArray();

        return result;
    }

    public static void main(String[] args) {


        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(((long) Integer.MAX_VALUE) +(long) 10) ));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

    }

    private static long arm (long NextArm){
        long result = 0;
        String s = Long.toString(NextArm);

        while (NextArm != 0){
            long digit = NextArm%10;
            result = (long) (result + Math.pow(digit, s.length()));
            NextArm = NextArm/10;
        }

        return result;
    }
}
