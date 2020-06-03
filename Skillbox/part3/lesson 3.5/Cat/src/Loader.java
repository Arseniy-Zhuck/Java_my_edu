import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader
{

    private static Cat generateCat() {
        Cat cat= Cat.getCat();
        return cat;
    }

    public static Cat[] generateCats(int catCount) {
        Cat[] cats= new Cat[catCount];
        for (int i = 0; i<catCount; i++){
            cats[i] = generateCat();
        }
        return cats;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to our new \"DOllY\" cat farm");
        System.out.println("Lets create oir cats");
        System.out.println("Sorry,but we don't know what should we do after their creation");
        System.out.println("May be \"Полиграф Полиграфович\"? Who Knows?");
        System.out.println("But we can create them");
        System.out.println("So, how many cats do you want?");
        Integer count = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
        Cat[] cats = generateCats(count);
        System.out.println("Congratulations, you've been created them");
        for (int i=0;i<Cat.getCount();i++) {
            System.out.println("Cat "+i+": "+cats[i].getWeight()+"  "+cats[i].getStatus());
        }
        System.out.println("Thats all!  Sharikovvv???? Come here,please");
    }
}