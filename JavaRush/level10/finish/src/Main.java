import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void printMap(Map<Character, Integer> map) {
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> letter = iterator.next();
            System.out.println(letter.getKey() + " " + letter.getValue());
        }
    }

    public static void task12() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        Map<Character, Integer> res = new LinkedHashMap<>();
        for (Character ch : alphabet) res.put(ch,0);
        printMap(res);
        for (int i = 0; i < 10; i++) {
            char[] chars = list.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (alphabet.contains(chars[j])) {
                    Integer count = res.get(chars[j]);
                    res.put(chars[j], count + 1);
                }
            }
        }
        printMap(res);
    }

    


    public static void main(String[] args) {
        //ArrayList<String>[] arrayOfStringList = createList();
        //printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] list = new ArrayList[5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i+2; j++) {
                list[i].add("Node № " + j + " in " + i + "element");
            }
        }
        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
