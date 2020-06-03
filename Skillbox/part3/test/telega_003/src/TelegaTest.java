import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthCheckedPhone;
import org.javagram.response.AuthSentCode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TelegaTest {
    public static void main(String[] args) throws IOException {

        String testAddr = "149.154.167.40:443";
        String prodAddr = "149.154.167.50:443";
        Integer appId = 1376098;
        String appHash = "5db92109022ff9f89bf5405c16657a0f";
        String phoneNumber = "79384754442";

        TelegramApiBridge bridge = new TelegramApiBridge(prodAddr,
                appId, appHash);
        System.out.println("Please type your phone number:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        AuthCheckedPhone checkPhone = bridge.authCheckPhone(phoneNumber);

        if (checkPhone.isRegistered()) {
            bridge.authSendCode(phoneNumber);
            System.out.println("Please type confirm code");
            String code = new BufferedReader(new InputStreamReader(System.in)).readLine();
            AuthAuthorization authAuthorization = bridge.authSignIn(code);
            String name = authAuthorization.getUser().getFirstName() + " " + authAuthorization.getUser().getLastName();
            System.out.println("Authorized name: " + name.trim());
        } else {
            System.out.println("Please type registered number");
        }

    }
}
