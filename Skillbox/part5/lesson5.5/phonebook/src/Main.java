import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Main {

    public static void printPhoneBook(Map<String, String> map) {
        Iterator <Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> node = iterator.next();
            System.out.println(node.getKey() + " has phonenumber " + node.getValue());
        }
    }

    public static boolean checkFIO(String s) {
        return Pattern.compile("[А-ЯЁ&&[^ЪЬЫ]][а-яё]+\\s[А-ЯЁ&&[^ЪЬЫ]][а-яё]+\\s" +
                "[А-ЯЁ&&[^ЪЬЫ]][а-яё]+$").matcher(s).matches();
    }

    public static String formatPhone(String phone) {
        return phone.replaceAll("[^0-9]","");
    }

    public static Boolean checkPhone(String phone) {
        return Pattern.compile("[0-9]{11}").matcher(phone).matches();
    }

    public static Map.Entry<String, String> getNodeByPhone(Map<String, String> phonebook, String phone) {
        //Map.Entry<String, String> result = null;
        Map.Entry<String, String> pair = null;
        Iterator<Map.Entry<String, String>> iterator = phonebook.entrySet().iterator();
        boolean res = false;
        while ((!res)&&(iterator.hasNext())) {
            pair = iterator.next();
            res = res | pair.getValue().equals(phone);
        }
        return pair;
    }


    public static void main(String[] args) throws IOException {
        Map<String,String> phoneBook = new TreeMap<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Here we have intelligent phonebook");

        while (true) {
            System.out.println("Please, type FIO or phone or command");
            String command = bufferedReader.readLine();
            if (command.equals("LIST")) {
                printPhoneBook(phoneBook);
                break;
            }
            if (checkFIO(command)) {
                if (phoneBook.containsKey(command)) {
                    System.out.println(command + " has phonenumber " + phoneBook.get(command));
                    continue;
                } else {
                    System.out.println("New node:" + command);
                    System.out.println("Print phonenumber, please");
                    String s = bufferedReader.readLine();
                    String phonenumber = formatPhone(s);
                    phoneBook.put(command, phonenumber);
                    continue;
                }
            } else if (checkPhone(formatPhone(command))) {
                String phone = formatPhone(command);
                if (phoneBook.containsValue(phone)) {
                    System.out.println(getNodeByPhone(phoneBook,phone).getKey() + " has phonenumber " + phone);
                    continue;
                } else {
                    System.out.println("New node: command");
                    boolean flag = false;
                    String FIO = "";
                    do {
                        System.out.println("Print correct FIO, please");
                        FIO = bufferedReader.readLine().trim();
                        flag = checkFIO(FIO);
                    } while (!flag);
                    phoneBook.put(FIO,phone);
                    continue;
                }
            } else {
                System.out.println("Cannot recognize FIO, phone or command");
                continue;
            }
        }
    }
}
