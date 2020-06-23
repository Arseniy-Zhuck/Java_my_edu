import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static Map<String, String> readRegions() throws IOException {
        File file = new File(".\\src\\regions.txt");
        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку
        Map<String, String> regions = new HashMap<>();
        String line = reader.readLine();
        while (line != null) {
            String regName = line.substring(0,line.indexOf("\t"));
            String regNumbers = line.substring(line.indexOf("\t")+1);
            //System.out.println(regName+"   "+regNumbers);
            regNumbers = regNumbers.trim();
            int index = regNumbers.indexOf(", ");
            while (index != -1) {

                String regNumber = regNumbers.substring(0, index);
               // System.out.println(regNumber + " - " + regName);
                regions.put(regNumber, regName);
                regNumbers = regNumbers.substring(index + 1);
                //System.out.println(regNumbers);
                regNumbers = regNumbers.trim();
                index = regNumbers.indexOf(", ");
            }
            regNumbers = regNumbers.trim();
            regions.put(regNumbers, regName);
            line = reader.readLine();
        }
        return regions;
    }




    public static ArrayList<String> generateNumbers() throws IOException {
        ArrayList<String> goodNumbers = new ArrayList<>();
        Map<String, String> regions = readRegions();
        //printMap(regions);
        String reg, num, number;
        String[] lettersRus = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        String[] lettersEng = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
        Iterator<Map.Entry<String, String>> iterMap = regions.entrySet().iterator();
        while (iterMap.hasNext()) {
            Map.Entry<String, String> pair = iterMap.next();
            reg = pair.getKey();
            for (int i = 0; i < 10; i++) {
                num = "" + i + i + i;
                for (int j = 0; j < lettersRus.length; j++) {
                    for (int k = 0; k < lettersRus.length; k++) {
                        for (int l = 0; l < lettersRus.length; l++) {
                            number = lettersRus[j] + num + lettersRus[k] + lettersRus[l] + " " + reg;
                            goodNumbers.add(number);
                            number = lettersEng[j] + num + lettersEng[k] + lettersEng[l] + " " + reg;
                            goodNumbers.add(number);
                        }
                    }

                }
            }
        }
        return goodNumbers;
    }

    public static void printMap(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> pair = iter.next();
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }

    public static void printList(ArrayList<String> list) {
        for (String s : list) System.out.println(s);
        System.out.println(list.size());
    }

    public static boolean inList(ArrayList<String> list, String elem) {
        boolean res = false;
        Iterator<String> iter = list.iterator();
        while ((iter.hasNext())&&(!res)) {
            res = res || iter.next().equals(elem);
        }
        return res;

    }

    public static boolean inListLib(ArrayList<String> list, String elem) {
        return list.contains(elem);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> goodNumbers = generateNumbers();

        printList(goodNumbers);
        while (true) {
            System.out.println("Write car number in format X000XX REG  or write command");
            String s = br.readLine();
            if (s.equals("quit")) break;
            else {
                long timeMine,timeLib;
                boolean resMine, resLib;
                long startTime = System.currentTimeMillis();
                resMine = inList(goodNumbers, s);
                long finishTime = System.currentTimeMillis();
                timeMine = finishTime - startTime;
                startTime = System.currentTimeMillis();
                resLib = inListLib(goodNumbers, s);
                finishTime = System.currentTimeMillis();
                timeLib = finishTime - startTime;
                System.out.println("My method: result - " + resMine +", time - " + timeMine + ".");
                System.out.println("Lib method: result - " + resLib +", time - " + timeLib + ".");
            }

        }


    }
}
