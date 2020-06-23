import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        int[] numbers = new int[array.length];
        String[] words = new String[array.length];
        int numbersCount = 0;
        int wordsCount = 0;
        for (String s: array) {
            if (isNumber(s)) numbers[numbersCount++] = Integer.parseInt(s);
            else words[wordsCount++] = s;
        }
        int count = 1;
        while (count != 0) {
            count = 0;
            for (int i = 0; i < wordsCount - 1; i++) {
                if (isGreaterThan(words[i], words[i+1])) {
                    String t = words[i];
                    words[i] = words[i+1];
                    words[i+1] = t;
                    count++;
                }
            }
        }
        count = 1;
        while (count != 0) {
            count = 0;
            for (int i = 0; i < numbersCount - 1; i++) {
                if (numbers[i] < numbers[i+1]) {
                    int t = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = t;
                    count++;
                }
            }
        }
        int m=0;
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) array[i] = String.valueOf(numbers[n++]);
            else array[i] = words[m++];
        }



        // напишите тут ваш код
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
