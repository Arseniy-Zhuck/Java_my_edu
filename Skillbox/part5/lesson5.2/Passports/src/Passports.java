import java.io.*;

public class Passports {
    public static void main(String[] args) throws IOException {
        String[] series = new String[85*23];
        int k = 0;
        int[] regions = new int[85];
        File file = new File(".\\src\\regions.txt");
        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку
        //String englishText = "";
        String line = reader.readLine();
        int reg = 0;
        while ((line != null)&&(line != "")) {
            regions[reg++] = Integer.parseInt(line);
            line = reader.readLine();
        }
        for (int i = 0; i < 85; i++) { // номера регионов России
                String s;
                if (regions[i] < 10) s = "0" + i; // чтобы 03,04 сделать
                else s = String.valueOf(regions[i]);
                s += " ";
                for (int j = 97; j < 100; j++) {
                    String s1 = String.valueOf(j);
                    series[k++] = s + s1;
                }
                for (int j = 0; j < 20; j++) {
                    String s1;
                    if (j < 10) s1 = "0" + j;
                    else s1 = String.valueOf(j);
                    series[k++] = s + s1;
                }

        }
        for (int i = 0; i < 85*23; i++) {
            System.out.println(series[i]);
        }
    }
}
