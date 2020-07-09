import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void printVertabrates(ArrayList<Vertebrate> vertebrates) {
        System.out.println("You have " + vertebrates.size() + " vertebrates");
        for (Vertebrate vertebrate : vertebrates) System.out.println(vertebrate);
    }
    // Вопрос, понимаю, может это позже будет, но все равно, а в Java есть возможность имя класса аргументом передавать?
    // как-то так чтобы можно было делать       if (bird instanceof className) {}
    public static ArrayList<Vertebrate> getHens(ArrayList<Vertebrate> vertebrates) {
        ArrayList<Vertebrate> hens = new ArrayList<>();
        for (Vertebrate vertebrate : vertebrates)
            if (vertebrate instanceof Hen) hens.add(vertebrate);
        return hens;
    }

    public static ArrayList<Vertebrate> getHomeDucks(ArrayList<Vertebrate> vertebrates) {
        ArrayList<Vertebrate> homeDucks = new ArrayList<>();
        for (Vertebrate vertebrate : vertebrates)
            if (vertebrate instanceof HomeDuck) homeDucks.add(vertebrate);
        return homeDucks;
    }

    public static ArrayList<Vertebrate> getWildDucks(ArrayList<Vertebrate> vertebrates) {
        ArrayList<Vertebrate> wildDucks = new ArrayList<>();
        for (Vertebrate vertebrate : vertebrates)
            if (vertebrate instanceof WildDuck) wildDucks.add(vertebrate);
        return wildDucks;
    }

    public static ArrayList<Vertebrate> getSparrows(ArrayList<Vertebrate> vertebrates) {
        ArrayList<Vertebrate> sparrows = new ArrayList<>();
        for (Vertebrate vertebrate : vertebrates)
            if (vertebrate instanceof Sparrow) sparrows.add(vertebrate);
        return sparrows;
    }

    public static ArrayList<Vertebrate> getOstichs(ArrayList<Vertebrate> vertebrates) {
        ArrayList<Vertebrate> ostichs = new ArrayList<>();
        for (Vertebrate vertebrate : vertebrates)
            if (vertebrate instanceof Ostich) ostichs.add(vertebrate);
        return ostichs;
    }

    public static ArrayList<Vertebrate> getFrogs(ArrayList<Vertebrate> vertebrates) {
        ArrayList<Vertebrate> frogs = new ArrayList<>();
        for (Vertebrate vertebrate : vertebrates)
            if (vertebrate instanceof Frog) frogs.add(vertebrate);
        return frogs;
    }

    public static void comeToVertebrates(ArrayList<Vertebrate> vertebrates) {
        for (Vertebrate vertebrate : vertebrates) {
            vertebrate.voice();
            vertebrate.moveForALittle();
        }
    }

    public static void frightenVertebrates(ArrayList<Vertebrate> vertebrates) {
        for (Vertebrate vertebrate : vertebrates) {
            vertebrate.voice();
            vertebrate.move();
        }
    }

    public static void feedVertebrates(ArrayList<Vertebrate> vertebrates) {
        for (Vertebrate vertebrate : vertebrates) {
            vertebrate.voice();
            vertebrate.eat();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Vertebrate> vertebrates = new ArrayList<>();
        Random random = new Random();
        int i = 0;
        while (i < 10) {
            int choice = random.nextInt(6);
            switch (choice) {
                case 0: vertebrates.add(new Hen("vertebrate № " + i++));
                        break;
                case 1: vertebrates.add(new HomeDuck("vertebrate № " + i++));
                        break;
                case 2: vertebrates.add(new WildDuck("vertebrate № " + i++));
                    break;
                case 3: vertebrates.add(new Sparrow("vertebrate № " + i++));
                    break;
                case 4: vertebrates.add(new Ostich("vertebrate № " + i++));
                    break;
                case 5: vertebrates.add(new Frog("vertebrate № " + i++));
                    break;
                default:
            }
        }
        System.out.println("---------------------------------------");
        System.out.println(" HENS: ");
        printVertabrates(getHens(vertebrates));
        System.out.println("---------------------------------------");
        Thread.sleep(5000);
        System.out.println(" WILDDUCKS: ");
        printVertabrates(getWildDucks(vertebrates));
        System.out.println("---------------------------------------");
        Thread.sleep(5000);
        System.out.println(" HOMEDUCKS: ");
        printVertabrates(getHomeDucks(vertebrates));
        System.out.println("---------------------------------------");
        Thread.sleep(5000);
        System.out.println(" SPARROWS: ");
        printVertabrates(getSparrows(vertebrates));
        System.out.println("---------------------------------------");
        Thread.sleep(5000);
        System.out.println(" OSTICHES: ");
        printVertabrates(getOstichs(vertebrates));
        System.out.println("---------------------------------------");
        Thread.sleep(5000);
        System.out.println(" FROGS: ");
        printVertabrates(getFrogs(vertebrates));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------------------------");
        Thread.sleep(5000);
        System.out.println("We are going to vertebrates");
        Thread.sleep(5000);
        comeToVertebrates(vertebrates);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------------------------");
        Thread.sleep(10000);
        System.out.println("now we want to sort vertebrates");
        Collections.sort(vertebrates);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------------------------");
        Thread.sleep(10000);
        System.out.println("We are going to feed vertebrates");
        feedVertebrates(vertebrates);
        System.out.println();
        System.out.println();
        System.out.println();
        Collections.shuffle(vertebrates);
        Thread.sleep(10000);
        printVertabrates(vertebrates);
        //Comparator<Vertebrate> comparator = new VertebrateComparator()
        vertebrates.sort(new VertebrateComparator());
        Thread.sleep(10000);
        printVertabrates(vertebrates);
        System.out.println("oh yeah they are sorted again");
        System.out.println("oh, fuck...");
        Thread.sleep(10000);
        frightenVertebrates(vertebrates);
        Thread.sleep(5000);

    }
}
