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

    public static void lesson2() {
        Cat cat = new Cat();
        System.out.println(cat);
        cat.feed(150.0);
        System.out.println(cat);
        for (int i=0;i<5;i++) cat.pee();
        System.out.println(cat);
        System.out.println(cat.getEatAmount());
    }

    public static int chooseCat() throws IOException {
        System.out.println("What cat do you want?");
        return SimpleReading.readInteger();
    }

    public static int chooseJob() throws IOException {
        System.out.println("What do you want?\n" +
                "1. Feed cat\n" +
                "2. Drink Cat\n" +
                "3. Play with cat\n" +
                "4. Get cat to the toilet\n" +
                "0. Get out of here");
        return SimpleReading.readInteger();
    }

    public static void doJob(int job, Cat cat) throws IOException {
        switch (job) {
            case 1:
                System.out.println("How many food you give cat?");
                double food = SimpleReading.readDouble();
                cat.feed(food);
                break;
            case 2:
                System.out.println("How many water you give cat?");
                double water = SimpleReading.readDouble();
                cat.feed(water);
                break;
            case 3:
                for(int i=0; i<10;i++) cat.meow();
                break;
            case 4:
                cat.pee();
                break;
            case 0: break;
            default:
                System.out.println("Unknown command");
        }
    }

    public static void lesson3() throws IOException {
        System.out.println("How many cats do you want?");
        int job = 1;
        int count = SimpleReading.readInteger();
        Cat[] cats = new Cat[count];
        for (int i= 0; i<count;i++) cats[i]= new Cat();
        while (job!=0) {
            System.out.println("We have " + Cat.getCatCount() + "alive cats");
            showCats(cats);
            Cat currentCat = cats[chooseCat()];
            job = chooseJob();
            doJob(job,currentCat);
        }

    }


    public static void main(String[] args) throws IOException {
        lesson3();
    }
}