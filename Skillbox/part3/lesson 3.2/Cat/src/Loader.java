import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader
{



    public static void main(String[] args) throws IOException {
        CatZoo myCatZoo= CatZoo.getCatZoo();
        System.out.println("How many cats do you wanna kill?");
        Integer count = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
        myCatZoo.catchCats(count);
        for (int i=0;i<count; i++) {
            myCatZoo.getCat(i);
            myCatZoo.catMurder(i,myCatZoo.chooseJoy());
            System.out.println("There are "+myCatZoo.countAliveCats()+" alive cats left");
        }
        myCatZoo.goodbye();




    }
}