import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void part1(){
        for (int i = 0; i < 512; i++)
            System.out.println((char) i);
//        String s = "абвгдАБВГД";
//        for (int i = 0; i < s.length(); i++)
//            System.out.println((int) s.charAt(i));
//        System.out.println((int) (s.charAt(0)));
//        System.out.println((int) (s.charAt(1)));
        for(int i=1072; i<=1077;i++) {
            System.out.println((char)i+" = "+i+", "+(char)(i-32)+" = "+(i-32));
        }
        System.out.println((char) 1105 + " = " + 1105 + ", " + (char)1025 + " = " + 1025);
        for(int i=1078; i<=1103;i++) {
            System.out.println((char)i+" = "+i+", "+(char)(i-32)+" = "+(i-32));
        }
        int i = (int)'Ё';
        int j = 'ё';
        System.out.println(i+" "+j);
        // ну это в UTF-8
        // получается русские буквы от 1040 до 1071 и строчные от 1072 и дальше
    }

    public static void part3() throws IOException {
        System.out.println("Введите строку");
        String startS = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        String s = startS.trim();
        String surname = s.substring(0,s.indexOf(' '));
        startS = s.substring(s.indexOf(' '));
        s = startS.trim();
        String name = s.substring(0, s.indexOf(" "));
        String lastname = s.substring(s.indexOf(" ")).trim();
        System.out.println("Фамилия: " + surname);
        System.out.println("Имя: " + name);
        System.out.println("Отчество: " + lastname);

    }


    public static void main(String[] args) throws IOException {
        part1();

    }
}
