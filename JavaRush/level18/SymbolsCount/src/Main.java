import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src/EnglishText.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        Map<Character, Integer> lettersCount = new TreeMap<>();
        while (line != null) {
            char[] letters = line.toCharArray();
            for (char letter : letters) {
                int count = 0;
                if (lettersCount.containsKey(letter))
                    count = lettersCount.get(letter);
                lettersCount.put(letter, count + 1);
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();
        for (Character letter : lettersCount.keySet()) {
            System.out.println(letter + " " + lettersCount.get(letter));
        }
    }
}
