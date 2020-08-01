import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Set<FileName> fileNames = new TreeSet<>();
        while (true) {
            String line = consoleBufferedReader.readLine();
            if (line.equals("end")) break;
            fileNames.add(new FileName(line));
        }
        consoleBufferedReader.close();

        File mainFile = new File("src/" + FileName.getMainName());
        FileOutputStream mainFileOutputStream = new FileOutputStream(mainFile);
        BufferedOutputStream mainFileBufferedOutputStream = new BufferedOutputStream(mainFileOutputStream);
        Iterator<FileName> iterator = fileNames.iterator();
        while (iterator.hasNext()) {
            FileName currentFileName = iterator.next();
            File currentFile = new File("src/" + currentFileName.getName());
            FileInputStream currentFileInputStream = new FileInputStream(currentFile);
            BufferedInputStream currentFileBufferedInputStream = new BufferedInputStream(currentFileInputStream);
            int i;
            while (currentFileBufferedInputStream.available() > 0) {
                i = currentFileBufferedInputStream.read();
                mainFileBufferedOutputStream.write(i);
            }
            currentFileBufferedInputStream.close();
            currentFileInputStream.close();
        }
        mainFileBufferedOutputStream.close();
        mainFileOutputStream.close();
    }

    public static class FileName implements Comparable<FileName>{
        private static String mainName;
        private static final String part = "part";
        private int partNumber;
        private String name;

        public FileName(String name) {
            this.name = name;
            String[] parts = name.split("\\.");
            if (mainName == null) {
                mainName = parts[0];
                for (int i = 1; i < parts.length - 1; i++) {
                    mainName += "." + parts[i];
                }
            }
            String lastPart = parts[parts.length - 1];
            partNumber = Integer.parseInt(lastPart.substring(4));
        }

        public static String getMainName() {
            return mainName;
        }

        @Override
        public int compareTo(FileName o) {
            return this.partNumber - o.partNumber;
        }

        public String getName() {
            return name;
        }
    }
}
