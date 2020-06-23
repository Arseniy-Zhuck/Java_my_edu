import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthCheckedPhone;


import java.io.IOException;

public class Loader {


   public static String check(String phone) {
            return phone.replaceAll("[^0-9]","");
        }

    public static void main(String[] args) throws IOException {
        TelegramApiBridge bridge= new TelegramApiBridge("149.154.167.50:443",
                1376098,"5db92109022ff9f89bf5405c16657a0f");
        //System.out.println("something");
        System.out.println("Please, type your phone number");
        String s=SimpleReading.readString();
        String phoneNumber = check(s);
        AuthCheckedPhone checkedPhone=bridge.authCheckPhone(phoneNumber);
        if (checkedPhone.isRegistered()) {
            System.out.println("Now you will have confirmation code on your phone");
            bridge.authSendCode(phoneNumber);
            String confirmCode= SimpleReading.readString();
            AuthAuthorization authAuthorization= bridge.authSignIn(confirmCode);
            System.out.println("Authorization is success");
            System.out.println(authAuthorization.getUser().getFirstName()+"  "+
                    authAuthorization.getUser().getLastName());
        } else System.out.println("Your mobile phone is not registered, WHY???");
    }
}
