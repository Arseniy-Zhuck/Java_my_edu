public class Sparrow extends FlyingBird{
    public Sparrow(String name) {
        super(name);
    }

    public Sparrow(String name, double weight) {
        super(name, weight);
    }

    private void catchFly() {
        System.out.println("Fucking fly will die");
    }

    @Override
    public void eat() {
        catchFly();
        super.eat();
    }

    @Override
    public void voice() {
        System.out.println("chik-chirik");
        super.voice();
    }


}
