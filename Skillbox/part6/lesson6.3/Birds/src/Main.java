import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void printBirds(ArrayList<Bird> birds) {
        System.out.println("You have " + birds.size() + " birds");
        for (Bird bird : birds) System.out.println(bird);
    }
    // Вопрос, понимаю, может это позже будет, но все равно, а в Java есть возможность имя класса аргументом передавать?
    // как-то так чтобы можно было делать       if (bird instanceof className) {}
    public static ArrayList<Bird> getHens(ArrayList<Bird> birds) {
        ArrayList<Bird> hens = new ArrayList<>();
        for (Bird bird : birds)
            if (bird instanceof Hen) hens.add(bird);
        return hens;
    }

    public static ArrayList<Bird> getHomeDucks(ArrayList<Bird> birds) {
        ArrayList<Bird> homeDucks = new ArrayList<>();
        for (Bird bird : birds)
            if (bird instanceof HomeDuck) homeDucks.add(bird);
        return homeDucks;
    }

    public static ArrayList<Bird> getWildDucks(ArrayList<Bird> birds) {
        ArrayList<Bird> wildDucks = new ArrayList<>();
        for (Bird bird : birds)
            if (bird instanceof WildDuck) wildDucks.add(bird);
        return wildDucks;
    }

    public static ArrayList<Bird> getSparrows(ArrayList<Bird> birds) {
        ArrayList<Bird> sparrows = new ArrayList<>();
        for (Bird bird : birds)
            if (bird instanceof Sparrow) sparrows.add(bird);
        return sparrows;
    }

    public static ArrayList<Bird> getOstichs(ArrayList<Bird> birds) {
        ArrayList<Bird> ostichs = new ArrayList<>();
        for (Bird bird : birds)
            if (bird instanceof Ostich) ostichs.add(bird);
        return ostichs;
    }

    public static void comeToBirds(ArrayList<Bird> birds) {
        for (Bird bird : birds) {
            System.out.println(bird);
            bird.walk(5000);
        }
    }

    public static void frightenBirds(ArrayList<Bird> birds) {
        for (Bird bird : birds) {
            System.out.println(bird);
            bird.run(200);
        }
    }

    public static void feedBirds(ArrayList<Bird> birds) {
        for (Bird bird : birds) {
            System.out.println(bird);
            bird.eat();
        }
    }

    public static void main(String[] args) {
        ArrayList<Bird> birds = new ArrayList<>();
        Random random = new Random();
        int i = 0;
        while (i < 10) {
            int choice = random.nextInt(5);
            switch (choice) {
                case 0: birds.add(new Hen("bird № " + i++));
                        break;
                case 1: birds.add(new HomeDuck("bird № " + i++));
                        break;
                case 2: birds.add(new WildDuck("bird № " + i++));
                    break;
                case 3: birds.add(new Sparrow("bird № " + i++));
                    break;
                case 4: birds.add(new Ostich("bird № " + i++));
                    break;
                default:
            }
        }
        System.out.println("---------------------------------------");
        System.out.println(" HENS: ");
        printBirds(getHens(birds));
        System.out.println("---------------------------------------");
        System.out.println(" WILDDUCKS: ");
        printBirds(getWildDucks(birds));
        System.out.println("---------------------------------------");
        System.out.println(" HOMEDUCKS: ");
        printBirds(getHomeDucks(birds));
        System.out.println("---------------------------------------");
        System.out.println(" SPARROWS: ");
        printBirds(getSparrows(birds));
        System.out.println("---------------------------------------");
        System.out.println(" OSTICHES: ");
        printBirds(getOstichs(birds));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("We are going to birds");
        comeToBirds(birds);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("We are going to feed birds");
        feedBirds(birds);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("oh, fuck...");
        frightenBirds(birds);

    }
}
