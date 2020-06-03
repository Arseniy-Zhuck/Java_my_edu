import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader
{
    public static void welcome() {
        System.out.println("Wellcome to simple Tamagochiy");
        System.out.println("Here you can have only one cat");
        System.out.println("Lets get it");
    }

    public static void goodbye() {
        System.out.println("Do svidaniya!!!");
    }

    public static int choice() throws IOException {
        System.out.println("What do you want to do with your cat?");
        System.out.println("1. Feed");
        System.out.println("2. Drink");
        System.out.println("3. Meow");
        System.out.println("4. Toilet");
        return Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
    }

    public static void make(int ch, Cat cat) throws IOException {
        if (ch==1) {
            System.out.println("How much should it eat?");
            cat.feed(Double.parseDouble((new BufferedReader(new InputStreamReader(System.in))).readLine()));
        } else if (ch==2) {
            System.out.println("How much should it drink?");
            cat.drink(Double.parseDouble((new BufferedReader(new InputStreamReader(System.in))).readLine()));
        } else if (ch==3) {
            cat.meow();
        } else cat.toilet();
    }

    public static String result(Cat cat) {
        if ((cat.getStatus().equals("Sleeping"))||(cat.getStatus().equals("Playing"))) {
            return "OUU you love cats)))";
        } else if (cat.getActCount()>15) {
                return "You are not so bad, but you should training more";
        } else return "Sharikov, opyat ti?";


    }

    public static void main(String[] args) throws IOException {
        welcome();
        System.out.println("Do you wanna play? Yes/...");
        String answer = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        if (answer.toLowerCase().equals("yes")) {
            Cat myCat = Cat.getCat();
            System.out.println("Your cat is "+myCat.getStatus());
            System.out.println("What's the name of your cat?");
            myCat.setName((new BufferedReader(new InputStreamReader(System.in))).readLine());
            int ch= choice();
            while ((ch>0)&&(ch<5)&&((myCat.getStatus().equals("Sleeping"))||(myCat.getStatus().equals("Playing")))) {
                make(ch,myCat);

                System.out.println(myCat.getName()+ " is "+myCat.getStatus()+" now");
                if ((myCat.getStatus().equals("Sleeping"))||(myCat.getStatus().equals("Playing"))){
                    ch = choice();
                }
            }
            System.out.println(result(myCat));
            System.out.println("You feed your cat with "+myCat.getEaten());
            goodbye();
        } else goodbye();


    }
}