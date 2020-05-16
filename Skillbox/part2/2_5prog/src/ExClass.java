import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExClass {
    public static int max(int a,int b,int c)
    {
        if (a >= b && a >= c) {
            return a;
        }
        else if (b >= c) {
            return b;
        } else return c;
    }

    public static int min(int a,int b,int c)
    {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= c) {
            return b;
        } else return c;
    }

    public static int middle(int a,int b, int c)
    {
        if (( a>= b && b >= c) || (a <= b && b <= c)) {
            return b;
        } else if ((b >= a && a >= c) || (b <= a && a <= c)) {
            return a;
        } else return c;
    }

    public static void main(String[] args) throws IOException
    {

        System.out.println("Please enteger the first age");
        Integer firstAge = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
        System.out.println("Please enteger the second age");
        Integer secondAge = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
        System.out.println("Please enteger the third age");
        Integer thirdAge = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
        Integer oldest;
        Integer youngest;
        Integer middle;

        oldest = max(firstAge,secondAge,thirdAge);
        youngest = min(firstAge,secondAge,thirdAge);
        middle = middle(firstAge,secondAge,thirdAge);
        if (oldest == middle) {
            if (middle == youngest) {
                System.out.println("Oldest = Middle = youngest = " + middle);
            } else {
                System.out.println("Oldest = Middle  = " + middle);
                System.out.println("Youngest: " + youngest);
            }
        } else if (middle == youngest) {
            System.out.println("Oldest: " + oldest);
            System.out.println("Middle = youngest = " + middle);
        } else {
            System.out.println("Oldest: " + oldest);
            System.out.println("Youngest: " + youngest);
            System.out.println("Middle = " + middle);
        }


    }
}
