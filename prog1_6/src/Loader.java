import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loader {

    public static void main(String[] args) {
        DateFormat df= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d= new Date();
        System.out.println(df.format(d));
    }
}
