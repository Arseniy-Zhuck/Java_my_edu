import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void exp() {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Start: ");
            String s = bufferedReader.readLine();
            for (;;) {
                list.add(1);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + " has happened");
        } finally {
            System.out.println("finally block");
        }
    }

    public static boolean exp2() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;
        try {
            System.out.println("Start block try please enter the number");
            index = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Block try 2");
            //System.exit(0);
            //break;
            return false;
            //System.out.println("Block try 3");
        } catch (IOException e) {
            System.out.println("Block Catch from IO");
            try {e.printStackTrace();} catch (Exception e1) {}
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Block catch from not Integer");
            e.printStackTrace();
            int[] a = new int[4];
            a[7] = 5;
            //index = Integer.parseInt(bufferedReader.readLine());
        }
        finally {
            System.out.println("Block finally");
            return index != 0;
        }
    }

    public static void main(String[] args) {
        //exp();
        System.out.println(exp2());
    }
}
