import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BirthDay {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1990,Calendar.DECEMBER,8);
        DateFormat dF = new SimpleDateFormat("dd.MM.YYYY - EEE");
        Date date = calendar.getTime();
        for (int i = 0; i < 30; i++) {
            date = calendar.getTime();
            System.out.println(i+ ". " + dF.format(date));
            calendar.add(Calendar.YEAR, 1);
        }
    }
}
