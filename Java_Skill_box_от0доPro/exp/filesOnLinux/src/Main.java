import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        File
        try (FileWriter writer = new FileWriter("1.txt", false)) {
            // запись всей строки
            for(String text : list) {
                writer.write(text);
                // запись по символам
                writer.append('\n');

            }
            writer.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
