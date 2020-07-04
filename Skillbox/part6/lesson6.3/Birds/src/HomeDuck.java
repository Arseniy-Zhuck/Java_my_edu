public class HomeDuck extends NonFlyingBird implements Duck{

    public HomeDuck(String name) {
        super(name);
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
}
