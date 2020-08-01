import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
//            if (args.length != 0) {
        BufferedReader consoleBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleBufferedReader.readLine();
        consoleBufferedReader.close();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader fileBufferedReader = new BufferedReader(fileReader);
        ArrayList<Good> arrayList = Good.getGoods(fileBufferedReader);
        fileBufferedReader.close();
        String[] arg = {"234",}
        if (args[0].equals("-u"))
            arrayList.add(arrayList.indexOf(new Good(args[1], null)), new Good(args[1], args[2], args[3],args[4]));
        else if (args[0].equals("-d"))
            arrayList.remove(new Good(args[1], null));

        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter fileBufferedWriter = new BufferedWriter(fileWriter);
        Good.writeList(arrayList, fileBufferedWriter);
        fileBufferedWriter.close();

  //  }
}

public static class Good {

    public static void writeList(List<Good> list, BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write(String.valueOf(list.get(0)));
        for (int i = 1; i < list.size(); i++) {
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(list.get(i)));
        }
    }

    public Good(String id, String name, String price, String count) {
        ID = addSpaces(id, 8);
        this.name = addSpaces(name, 30);
        this.price = addSpaces(price, 8);
        this.count = addSpaces(count, 4);
    }

    private static String addSpaces(String s, int length) {
        String newS = s;
        while (newS.length() < length) newS+=" ";
        return newS;
    }

    private Good(String note) {
        this(note.substring(0,8), note.substring(8,38), note.substring(38,46), note.substring(46));
    }

    public Good(String ID, String smth) {
        this.ID = ID;
    }

    public static ArrayList<Good> getGoods(BufferedReader bufferedReader) throws IOException {
        ArrayList<Good> goods = new ArrayList<>();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) break;
            goods.add(new Good(line));
        }
        return goods;
    }

    private String ID;
    private String name;
    private String price;
    private String count;

    public String getID() {
        return ID;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Good) {
            return ID.equals(((Good) obj).getID());
        } else return false;
    }

    @Override
    public String toString() {
        return ID+name+price+count;
    }
}

}
