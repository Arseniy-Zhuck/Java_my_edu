public class HomeDuck extends NonFlyingBird implements Duck{

    public HomeDuck(String name) {
        super(name);
    }

    public HomeDuck(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void swim(double meters) {
        System.out.println("Swimming " + meters + " meters");
    }

    @Override
    public void catchFish() {
        System.out.println("Ou, my master give me fish ...");

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
