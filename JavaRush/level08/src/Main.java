import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Random r = new Random();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(r.nextInt());
        }
        return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i>10) set.remove(i);
        }
        return set;
    }

    public static void printSet(Set<Integer> set)
    {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println(i);
        }
    }

    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        int year = 1970;
        int month = 1;
        int day = 5;
        for (int i = 0; i < 9; i++) {
            Date date = new Date();
            date.setDate(day++);
            date.setMonth(month++);
            date.setYear(year++);
            map.put("LastName"+i,date);
        }
        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> person = iterator.next();
            int i = person.getValue().getMonth();
            if ((i > 5) && (i < 9)) iterator.remove();
        }
    }

    public static void main(String[] args) throws ParseException {
        Map<String, Date> map = createMap();
        printMap(map);
        removeAllSummerPeople(map);
        printMap(map);
    }

    public static void printMap(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            System.out.println(pair.getKey().toString()+": "+pair.getValue().toString());
        }
    }


    public static void task3() {
        Map<String,String> map = new HashMap<>();
        map.put("арбуз","ягода");
        map.put("банан","трава");
        map.put("вишня","ягода");
        map.put("груша","фрукт");
        map.put("дыня","овощ");
        map.put("ежевика","куст");
        map.put("жень-шень","корень");
        map.put("земляника","ягода");
        map.put("ирис","цветок");
        map.put("картофель","клубень");
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,String> pair = iterator.next();
            String s1 = pair.getKey();
            String s2 = pair.getValue();
            System.out.println(s1 + " - " + s2);
        }
    }

    public static void task2() {
        Set<String> set = new HashSet<>();
        set.add("арбуз");
        set.add("банан");
        set.add("вишня");
        set.add("груша");
        set.add("дыня");
        set.add("ежевика");
        set.add("женьшень");
        set.add("земляника");
        set.add("ирис");
        set.add("картофель");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String text = iterator.next();
            System.out.println(text);
        }
    }
}
