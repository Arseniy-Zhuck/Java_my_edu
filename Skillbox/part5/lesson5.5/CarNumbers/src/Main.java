import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static Map<String, String> regions = null;
    public static Map<String, String> getRegionsFromFile(String pathname) throws IOException {
        File file = new File(pathname);
        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку
        Map<String, String> regions = new TreeMap<>();
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

    public static boolean isCarNumber(String s) {
        boolean result = true;
        result &= (s.length()==9)||(s.length()==10);
        //System.out.println(result);
        String number = s.substring(0,s.indexOf(" "));
        //System.out.println(number);
        String reg = s.substring(s.indexOf(" ")+1);
        //System.out.println(reg);
        // че-то не сразу зашло
        result &= Pattern.compile("[АВЕКМНОРСТУХABEKMHOPCTYX][0-9]{3}[АВЕКМНОРСТУХABEKMHOPCTYX][АВЕКМНОРСТУХABEKMHOPCTYX]").matcher(number).matches();

        //System.out.println(result);
        result &= regions.containsKey(reg);
        //System.out.println(result);
        return  result;
    }

    public static String toRusCarNumber(String s) {
        String result = s.replaceAll("A","А");
        result = result.replaceAll("B","В");
        result = result.replaceAll("E","Е");
        result = result.replaceAll("K","К");
        result = result.replaceAll("M","М");
        result = result.replaceAll("H","Н");
        result = result.replaceAll("O","О");
        result = result.replaceAll("P","Р");
        result = result.replaceAll("C","С");
        result = result.replaceAll("T","Т");
        result = result.replaceAll("Y","У");
        result = result.replaceAll("X","Х");
        return result;
    }

    public static String getRegion(String carNumber) {
        String reg = carNumber.substring(carNumber.indexOf(" ")+1);
        return regions.get(reg);
    }

    public static void printMap(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> pair = iter.next();
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }

    public static void main(String[] args) throws IOException {

        try {
            regions = getRegionsFromFile(".\\src\\regions.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, we cannot read regions from file");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("An error while reading regions occured");
            System.exit(0);
        }
        printMap(regions);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to carnumbers list");
        System.out.println("Hey, hello, people!!!!! Everything is cool");
        System.out.println("At last really normal task, yeehuuuu");
        Map<String, String> carNumbers = new TreeMap<>();
        while (true) {
            System.out.println("Please enter car number");
             String s = bufferedReader.readLine();
             if (s.equals("EXIT")) break;
             if (s.equals("LIST")) {
                Iterator<Map.Entry<String, String>> iter = carNumbers.entrySet().iterator();
                while (iter.hasNext()) {
                     Map.Entry<String, String> pair = iter.next();
                     System.out.println("Number: " + pair.getKey() + ", owner: " + pair.getValue() + " from " + getRegion(pair.getKey()));
                }
                continue;
             }
             if (!isCarNumber(s)) {
                 System.out.println("It is not car number");
                 continue;
             }
             String carNumber = toRusCarNumber(s);
             if (carNumbers.containsKey(carNumber)) {
                 System.out.println("Number: " + carNumber + ", owner: " + carNumbers.get(carNumber) + " from " + getRegion(carNumber));
             } else {
                 System.out.println("Please, enter name");
                 String name = bufferedReader.readLine();
                 carNumbers.put(carNumber, name);
             }
         }

    }
}
