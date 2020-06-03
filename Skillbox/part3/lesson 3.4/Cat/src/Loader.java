import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader
{   // у меня кончилась фантазия, поэтому просто выполненное задание
    public static void main(String[] args) throws IOException {
        System.out.println(Cat.getCount());
        String i = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        Cat cat = new Cat();
        System.out.println(Cat.getCount());
        i = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        Cat mur = new Cat();
        System.out.println(Cat.getCount());
        i = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        cat.drink(8000.0);
        System.out.println(cat.getStatus());
        System.out.println(Cat.getCount());
        i = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        Cat barmaley = new Cat();
        System.out.println(Cat.getCount());
        i = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        barmaley.feed(9000.0);
        System.out.println(barmaley.getStatus());
        System.out.println(Cat.getCount());
        i = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        while (!mur.getStatus().equals("Dead")) {
            mur.meow();
        }
        System.out.println(mur.getStatus());
        System.out.println(Cat.getCount());
        i = (new BufferedReader(new InputStreamReader(System.in))).readLine();



        //System.out.println(cat.getStatus());
    }
}