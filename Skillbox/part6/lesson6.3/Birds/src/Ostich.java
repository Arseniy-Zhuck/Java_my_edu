public class Ostich extends NonFlyingBird{
    public Ostich(String name) {
        super(name);
    }

    private void catchRat() {
        System.out.println("Fucking rat will die");
    }

    @Override
    public void run(double m) {
        super.run(m);
        System.out.println("It was very fast");
    }

    @Override
    public void eat() {
        catchRat();
        super.eat();
    }

}
