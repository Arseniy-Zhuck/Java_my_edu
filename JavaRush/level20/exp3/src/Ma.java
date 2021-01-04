import java.util.Arrays;
import java.util.TreeSet;

public class Ma {
    public static long[][] degrees = new long[10][20];
    static {
        for (int i = 0; i < 10; i++) {
            degrees[i][0] = 1L;
        }
        for (int i = 0; i < 10;i++)
            for (int j = 1; j < 20; j++ ) {
                degrees[i][j] = degrees[i][j - 1] * (long) i;
            }

    }

    public static boolean nextSochetanie(int[] sochetania, int granica) {

        if (sochetania[sochetania.length - 1] < granica) {
            sochetania[sochetania.length - 1]++;
            return true;
        } else {
            int k = sochetania.length - 2;

            int i = 0;
            try {
                while (sochetania[k--] == granica && (i++) < sochetania.length) {

                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }

            if (i > sochetania.length - 1) return false;
            else {
                sochetania[k+1]++;
                for (int j = k+2; j < sochetania.length; j++) {
                    sochetania[j] = sochetania[j-1];
                }
                return true;
            }
        }
    }

    public static long[] getNumbers(long N) {
        long[] result = null;
        if (N <= 1) return result;
        TreeSet<Long> armstrong = new TreeSet<>();
        int M = String.valueOf(N - 1).length();
        int granica = 9;
        int[] socetaniya = new int[M];
        for (int i = 0; i < M; i++) {
            socetaniya[i] = 0;
        }
        int i = 1;
        armstrong.add((long) 0);
        //System.out.println(i + ": " + Arrays.toString(socetaniya));
        while (nextSochetanie(socetaniya, granica)) {
            //System.out.println((++i) + ": " + Arrays.toString(socetaniya));

            int zeroCount = 0;
            for (int j = 0; j < socetaniya.length; j++) {
                if (socetaniya[j] == 0) zeroCount++;
            }
            for (int j = M; j >= M - zeroCount; j--) {
                long sum = (long) 0;
                for (int k = 0; k < socetaniya.length; k++) {
                    sum = sum + degrees[socetaniya[k]][j];
                }
                if (sum > 0 && (int) Math.log10(sum) + 1 == j && sum < N && check(sum)) {
                    //System.out.print(" - " + sum);
                    armstrong.add(sum);
                }

            }
            //System.out.println();
        }
        result = new long[armstrong.size()];
        i = 0;
        for (Long a : armstrong)
            result[i++] = a;

        return result;
    }

    public static boolean check(long S) {
        long a = S;
        int M = (int) (Math.log10(S)) + 1;
        long sum = 0;
        while (a > 0) {
            int k = (int) (a % (long) 10);
            sum += degrees[k][M];
            a = a /(long) 10;
        }
        return (sum == S);
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);


        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

    }
}
