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

    public static Integer choice() throws IOException {
        System.out.println("If you wanna create some count of new cats please enter 1");
        System.out.println("If you wanna clone your own cat please enter 2");
        System.out.println("If you wanna quit please enter any other number");
        return SimpleReading.readInteger();
    }

    public static void makeTheDeal(Integer choice) throws IOException {
        switch (choice)  {
            case 1: makeFewCats(); break;
            case 2: cloneYourCat(); break;
            default:
                System.out.println("Nu ok, dosvidaniya");
        }
    }

    public static void cloneYourCat() throws IOException {
        System.out.println("What's the name of your cat?");
        String firstcat=SimpleReading.readString();
        System.out.println("How much does it weight?");
        Double firstweight=SimpleReading.readDouble();
        Cat cat=Cat.getCat(firstweight);
        System.out.println("O, thank you for your "+firstcat+", it's so beatiful");
        System.out.println("Are you ready?");
        System.out.println("Right now you will see a miracle!!!!");
        Cat dolly=Cat.cloneCat(cat);
        System.out.println("now look");
        System.out.println(cat.getStatus());
        System.out.println(dolly.getStatus());
        if (Math.abs(cat.getWeight()-dolly.getWeight())<0.0000001) {
            System.out.println("It's all right");
            System.out.println("Please take your cats");
            System.out.println("We are working for you");
            System.out.println("1000000$");
        } else System.out.println("OH NOW SOMETHING BAD!!! RUN!!! FOREST RUN!!!!!");
    }

    public static void makeFewCats() throws IOException {
        System.out.println("Lets create your cats");
        System.out.println("So, how many cats do you want?");
        Integer count = SimpleReading.readInteger();
        Cat[] cats = generateCats(count);
        System.out.println("Congratulations, you've been created " + count + " cats");
        for (int i=0;i<Cat.getCount();i++) {
            System.out.println("Cat "+i+": "+cats[i].getWeight()+" "+cats[i].getStatus());
        }
        System.out.println("Thats all!  Sharikovvv???? Come here,please");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to our new \"DOllY\" cat farm");
        System.out.println("Here we have some improvements");
        makeTheDeal(choice());
    }
}