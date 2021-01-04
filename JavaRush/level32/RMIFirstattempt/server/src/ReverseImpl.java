import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ReverseImpl implements Reverse{
    @Override
    public String reverse(String s) throws RemoteException {
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.get(Calendar.HOUR) + " : " + calendar.get(Calendar.MINUTE) + " : " + calendar.get(Calendar.SECOND));
        return new StringBuffer(s).reverse().toString();
    }
}
