public class WildDuck extends FlyingBird implements Duck{
    public WildDuck(String name) {
        super(name);
    }

    public WildDuck(String name, double weight) {
        super(name, weight);
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

    @Override
    public void voice() {
        System.out.println("krya-krya-krya");
        super.voice();
    }

}
