import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileWorker {
    public static Map<String, String> readRegionsPassport() throws IOException {
        Map<String, String> regions = new LinkedHashMap<>();
        File file;
        FileReader fr;
        BufferedReader reader = null;

        file = new File(".\\src\\regionsPassport.txt");
            //создаем объект FileReader для объекта File
        fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
        reader = new BufferedReader(fr);
            // считаем сначала первую строку

        String line = "";
        line = reader.readLine();
        while (line != null) {
            String[] lines = line.split("\t");
            regions.put(lines[1],lines[0]);
            line = reader.readLine();
        }
        return regions;
    }

    public static ArrayList<Passport> readPassports() throws IOException, ParseException {
        ArrayList<Passport> arrayList = new ArrayList<>();
        File file;
        FileReader fr;
        BufferedReader reader;

            file = new File(".\\src\\passports.txt");
            //создаем объект FileReader для объекта File
            fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            reader = new BufferedReader(fr);
            // считаем сначала первую строку

        String line = reader.readLine();
        while (line != null) {
            arrayList.add( new Passport(line.split("\t")) );
            line = reader.readLine();
        }
        return arrayList;
    }

    public static void writePassports(ArrayList<Passport> passports) {
        try(FileWriter writer = new FileWriter(".\\src\\passports.txt", false))
        {
            // запись всей строки
            for(Passport passport : passports) {
                writer.write(passport.wholePassport());
                // запись по символам
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


}
