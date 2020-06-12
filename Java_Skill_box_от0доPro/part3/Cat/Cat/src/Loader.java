import java.io.IOException;

public class Loader
{

    public static void showCats(Cat[] cats) {
        for (Cat cat:cats) {
            System.out.println(cat);
        }
    }

    public static void explodeCat(Cat cat) {
        while (!cat.getStatus().equals("Exploded")) {
            cat.feed(1001.1);
        }
    }

    public static void spoilCat(Cat cat) {
        while (!cat.getStatus().equals("Exploded")) {
            cat.drink(1001.1);
        }
    }

    public static void playTillDeath(Cat cat) {
        while (!cat.getStatus().equals("Dead")) {
            cat.meow();
        }
    }

    public static void lesson1() throws IOException {
        Cat[] cats = new Cat[7];
        for (int i= 0; i<7;i++) cats[i]= new Cat();
        showCats(cats);
        System.out.println("Write \"next\"");
        String s = SimpleReading.readString();
        cats[0].feed(135.0);
        cats[1].feed(1001.2);
        showCats(cats);
        System.out.println("Write \"next\"");
        s = SimpleReading.readString();
        explodeCat(cats[2]);
        spoilCat(cats[3]);
        showCats(cats);
        System.out.println("Write \"next\"");
        s = SimpleReading.readString();
        playTillDeath(cats[5]);
        showCats(cats);
    }


    public static void main(String[] args) throws IOException {
        lesson1();
    }
}