public class Sparrow extends FlyingBird{
    public Sparrow(String name) {
        super(name);
    }

    private void catchFly() {
        System.out.println("Fucking fly will die");
    }

    @Override
    public void eat() {
        catchFly();
        super.eat();
    }


}
