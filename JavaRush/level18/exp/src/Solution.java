import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("1.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(String.valueOf(new MyClass("111","222", "333")));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static class MyClass {
        private String par1;
        private String part2;
        private String part3;


        public MyClass(String par1, String part2, String part3) {
            this.par1 = par1;
            this.part2 = part2;
            this.part3 = part3;
        }

        @Override
        public String toString() {
            return par1 + "  -  " + part2 + "  -  " + part3;
        }
    }

}
