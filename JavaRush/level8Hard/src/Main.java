import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main1(String[] args) {
        System.out.println(isGreaterThan("aaa","bbb"));
    }
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
    public static boolean isDateOdd(String date) {
        int month = 0;

        if (date.indexOf("JANUARY") > -1) month = 0;
        else
        if (date.indexOf("FEBRUARY") > -1) month = 1;
        else
        if (date.indexOf("MARCH") > -1) month = 2;
        else
        if (date.indexOf("APRIL") > -1) month = 3;
        else
        if (date.indexOf("MAY") > -1) month = 4;
        else
        if (date.indexOf("JUNE") > -1) month = 5;
        else
        if (date.indexOf("JULY") > -1) month = 6;
        else
        if (date.indexOf("AUGUST") > -1) month = 7;
        else
        if (date.indexOf("SEPTEMBER") > -1) month = 8;
        else
        if (date.indexOf("OCTOBER") > -1) month = 9;
        else
        if (date.indexOf("NOVEMBER") > -1) month = 10;
        else
        if (date.indexOf("DECEMBER") > -1) month = 11;
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] data = date.trim().split(" ");
        int year = Integer.parseInt(data[2]);

        if ((year % 400 == 0)||((year % 4 == 0)&&(year % 100 != 0)))
            days[1]++;
        int day = Integer.parseInt(data[1]);
        int i = 0;
        while (i < month) day += days[i];
        return day % 2 == 1;
    }




    public static void main(String[] args) {
//        Map<String, String> map = createMap();
//        printMap(map);
//        removeTheFirstNameDuplicates(map);
//        printMap(map);
        main1(args);
    }

    public static void printMap(Map<String, String> map) {
        for (Map.Entry<String, String> pair: map.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
    }

    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("Key " + i, "Value " + i/2);
        }
        return map;
        //напишите тут ваш код

    }


    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> newMap = new HashMap<>();
        while (!map.isEmpty()) {
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            Map.Entry<String,String> pair = iterator.next();
            newMap.put(pair.getKey(), pair.getValue());
            removeItemFromMapByValue(map, pair.getValue());
            System.out.println("------------------------------------------------");
            printMap(map);
        }
        Iterator<Map.Entry<String, String>> iterator = newMap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println("------------------------------------------------");
            printMap(map);
            Map.Entry<String,String> pair = iterator.next();
            map.put(pair.getKey(), pair.getValue());
        }
        //напишите тут ваш код

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }



}
