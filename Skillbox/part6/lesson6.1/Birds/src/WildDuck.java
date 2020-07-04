public class WildDuck extends FlyingBird implements Duck{
    public WildDuck(String name) {
        super(name);
    }


    @Override
    public void swim(double meters) {
        System.out.println("Swimming " + meters + " meters");
    }

    @Override
    public void catchFish() {
        System.out.println("Finding fish in water...");
    }

    @Override
    public void eat() {
        catchFish();
        super.eat();
    }

}
