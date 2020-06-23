public class Rainbow {
    public static void main(String[] args) {
        String[] rainbow = {"red", "orange" ,"yellow" , "green", "blue", "indigo", "violet"};
        // вывод в обратном порядке
        for (int i = rainbow.length - 1; i >=0; i--) {
            System.out.println(rainbow[i]);
        }
        // реверс массива на всякий случай, вдруг надо
        for (int i = 0; i < rainbow.length/2 - 1; i++) {
            String t = rainbow[i];
            rainbow[i] = rainbow[rainbow.length - 1 - i];
            rainbow[rainbow.length - 1 - i] = t;
        }
        for (String color : rainbow) System.out.println(color);
    }
}
