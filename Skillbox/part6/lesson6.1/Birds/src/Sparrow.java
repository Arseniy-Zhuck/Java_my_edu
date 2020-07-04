public class Sparrow extends FlyingBird{
    public Sparrow(String name) {
        super(name);
    }

    private void cathFly() {
        System.out.println("Fucking fly will die");
    }

    @Override
    public void eat() {
        cathFly();
        super.eat();
    }


}
