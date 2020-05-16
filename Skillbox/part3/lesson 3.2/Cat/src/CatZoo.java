import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CatZoo {
    private static CatZoo catZoo;
    private Cat[] cats;

    private CatZoo() {
        System.out.println("Welcome to our new special zoo \"Полиграф Полиграфович\" for cats!!!");
        System.out.println("And what is so special for it???");
        System.out.println("Well, it's cat murder paradize");
        System.out.println("Here you can: to meow cat till death; wake up cat just as they awake))");
        System.out.println("And our special event: you can explode your cat");
        System.out.println("Please if you are \"ХАНЖА\" don't disturb another people");
        System.out.println("We are Java-developers, we are strange");

    }

    public static CatZoo getCatZoo() {
        if (catZoo == null) {
            catZoo = new CatZoo();
        }
        return catZoo;
    }
    public void catchCats(int n) {
        cats = new Cat[n];
        for (int i=0; i<n; i++){
            cats[i] = new Cat("");
        }
    }

    public void getCat(int number) throws IOException {
        Cat cat= cats[number];
        System.out.println("you have the cat:");
        System.out.println(cat.getWeight());
        System.out.println(cat.getStatus());
        System.out.println("How we name it?");
        String name=(new BufferedReader(new InputStreamReader(System.in))).readLine();
        cat.setName(name);
    }

    public int chooseJoy() throws IOException {
        System.out.println("What do you want?");
        System.out.println("1. meow cat till death");
        System.out.println("2. explode your cat");
        System.out.println("3. to water your cat");
        Integer way = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
        return way;
    }

    private void waterCat(int cat) throws IOException {
        System.out.println(cats[cat].getWeight());
        while (!(cats[cat].getStatus().equals("Exploded"))) {
            System.out.println("water " + cats[cat].getName());
            System.out.println("Write water");
            String push = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            for (int i = 0; i < 50; i++) {
                cats[cat].drink(Double.parseDouble(Integer.toString(i)));
            }
        }
        System.out.println(cats[cat].getName()+" is already "+cats[cat].getStatus());
        cats[cat]=null;
    }


    private void explodeCat(int cat) throws IOException {
        System.out.println(cats[cat].getWeight());
        while (!(cats[cat].getStatus().equals("Exploded"))) {
            System.out.println("PILL " + cats[cat].getName());
            System.out.println("Write PILL");
            String push = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            for (int i = 0; i < 50; i++) {
                cats[cat].feed(Double.parseDouble(Integer.toString(i)));
            }
        }
        System.out.println(cats[cat].getName()+"  "+cats[cat].getStatus());
        cats[cat]=null;
    }
    private void meowCatToDeath(int cat) throws IOException {
        System.out.println(cats[cat].getWeight());
        while (!(cats[cat].getStatus().equals("Dead"))) {
            System.out.println("PUSH "+cats[cat].getName());
            System.out.println("Write PUSH");
            String push=(new BufferedReader(new InputStreamReader(System.in))).readLine();
            for (int i=0;i<500;i++) {
                cats[cat].meow();
            }
        }
        System.out.println(cats[cat].getName()+"  "+cats[cat].getStatus());
        cats[cat]=null;
    }

    public int countAliveCats(){
        Integer count=0;
        for (Cat cat : cats) {
            if (cat!=null) {
                count++;
            }
        }
        return count;
    }

    public void catMurder(int cat,int joy) throws IOException {
        if (joy == 1) {
            meowCatToDeath(cat);
        } else if (joy == 2) {
            explodeCat(cat);
        } else if (joy == 3) {
            waterCat(cat);
        } else {
            System.out.println("Sorry, we cannot have such function");
            System.out.println("But we can shot it with TT");
            cats[cat].killCat();
            cats[cat] =null;
        }
    }

    public void goodbye() {
        System.out.println("Да, это о тебе писал Михаил Афанасьевич");
    }



}
