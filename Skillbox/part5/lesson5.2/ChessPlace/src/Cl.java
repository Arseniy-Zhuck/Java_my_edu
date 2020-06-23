public class Cl {
    public static void main(String[] args) {
        char[] rows = {'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};
        for (int i = 0; i < 8; i++) {
            String s = "";
            for (int j = 0; j < 8; j++) {
                s =s + String.valueOf(rows[j]) + (i + 1) + " ";
            }
            System.out.println(s);
        }
        // тут же матричку надо было создать по идее, эээ
        System.out.println("//-------------------\\\\");
        String[][] field = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                field[i][j] = String.valueOf(rows[j]) + (i+1);
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(field[i][j]+" ");
            }
            System.out.print("\n");
        }

    }

}
