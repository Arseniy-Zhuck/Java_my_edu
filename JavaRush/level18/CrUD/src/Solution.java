import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
            if (true) {
        //        if ((args.length != 0)&&(args[0].equals("-c"))) {
            BufferedReader consoleBufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = consoleBufferedReader.readLine();
            consoleBufferedReader.close();

            FileReader fileReader = new FileReader(fileName);
            BufferedReader fileBufferedReader = new BufferedReader(fileReader);
            Good.buildMaxId(fileBufferedReader);
            fileBufferedReader.close();

            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter fileBufferedWriter = new BufferedWriter(fileWriter);
            fileBufferedWriter.newLine();
            fileBufferedWriter.write(String.valueOf(new Good(args[1],args[2],args[3])));
            fileBufferedWriter.close();
        }
    }

    public static class Good implements Comparable<Good>{
        public static String MaxID;

        private static String addSpaces(String s, int length) {
            String newS = s;
            while (newS.length() < length) newS+=" ";
            return newS;
        }

        public Good(String name, String price, String count) {
            this(getNextMaxID(), name, price, count);
        }

        private Good(String id, String name, String price, String count) {
            ID = addSpaces(id, 8);
            this.name = addSpaces(name, 30);
            this.price = addSpaces(price, 8);
            this.count = addSpaces(count, 4);
        }

        private Good(String note) {
            this(note.substring(0,7), note.substring(8,37), note.substring(38,45), note.substring(46));
        }

        public static String getNextMaxID() {
            String s = String.valueOf(Integer.parseInt(MaxID.trim()) + 1);
            MaxID = addSpaces(s,8);
            return MaxID;
        }

        public static void buildMaxId(BufferedReader bufferedReader) throws IOException {
            TreeSet<Good> treeSet = new TreeSet<>();
            while (true) {
                String line = bufferedReader.readLine();
                if (line.length() != 50) break;
                treeSet.add(new Good(line));
            }
            Iterator<Good> iterator = treeSet.iterator();
            String s = iterator.next().getID();
            MaxID = s;
        }

        private String ID;
        private String name;
        private String price;
        private String count;

        public String getID() {
            return ID;
        }

        @Override
        public String toString() {
            return ID+name+price+count;
        }

        @Override
        public int compareTo(Good o) {
            return - Integer.parseInt(this.ID.trim()) + Integer.parseInt(o.getID().trim());
        }
    }
}
