import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoneCheck {
    public static String check(String phone) {
        return phone.replaceAll("[^0-9]","");
    }


    public static void main(String[] args) throws IOException {
        System.out.println("Please, enter your mobile phone in any way you like");
        String phoneNumber = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        String correctPhone = check(phoneNumber);
        System.out.println(correctPhone);
    }
}
