public class Ostich extends NonFlyingBird{
    public Ostich(String name) {
        super(name);
    }

    public Ostich(String name, double weight) {
        super(name, weight);
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

    @Override
    public void voice() {
        System.out.println("uuuu-uuu-uuu-uu-uu");
        super.voice();
    }

}
