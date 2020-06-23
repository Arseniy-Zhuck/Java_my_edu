import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class Main {
    public static void task07(){
        try {
            int i = 40 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
        }
    }

    public static void task11() {
        HashMap map = new HashMap(null);
        map.put(null, null);
        map.remove(null);


    }

    public static void task12() {
        int num = Integer.parseInt("XYZ");
        System.out.println(num);
    }

    public static void task22() throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        DateFormat dateFormatRead = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
            date = dateFormatRead.parse(bufferedReader.readLine());
        System.out.println(dateFormatRead.format(date));
            DateFormat dateFormatWrite = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
            System.out.println(dateFormatWrite.format(date).toUpperCase());
    }

    public static void main(String[] args) throws IOException, ParseException {
        //task07();
        //task11();
        //task12();
        task22();
    }
}
