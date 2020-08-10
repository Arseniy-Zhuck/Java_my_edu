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
            int max = granica - 1;
            int i = 0;
            try {
                while (sochetania[k--] == max-- && (i++) < sochetania.length) {

                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }

            if (i > sochetania.length - 1) return false;
            else {
                sochetania[k+1]++;
                for (int j = k+2; j < sochetania.length; j++) {
                    sochetania[j] = sochetania[j-1] + 1;
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
        int granica = 10 + M - 1;
        int[] socetaniya = new int[9];
        for (int i = 0; i < 9; i++) {
            socetaniya[i] = i+1;
        }
        int i = 1;
        //System.out.println(i + ": " + Arrays.toString(socetaniya));
        while (nextSochetanie(socetaniya, granica)) {
            //System.out.println((++i) + ": " + Arrays.toString(socetaniya));
            int[] cifri = new int[10];
            cifri[0] = socetaniya[0] - 1;
            for (int j = 1; j < 9; j++) {
                cifri[j] = socetaniya[j] - socetaniya[j - 1] - 1;
            }
            cifri[9] = granica - socetaniya[8];
//            String s = "";
//            for (int j = 0; j < 10; j++) {
//                for (int k = 0; k < cifri[j]; k++) {
//                    s += j;
//                }
//            }
            //System.out.print((++i) + ": " + Arrays.toString(socetaniya) + " - " + s);
            int zeroCount = cifri[0];
            for (int j = M; j >= M - zeroCount; j--) {
                long sum = (long) 0;
                for (int l = 0; l < 10; l++) {
                    for (int k = 0; k < cifri[l]; k++) {
                        sum = sum + degrees[l][j];
                    }
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
