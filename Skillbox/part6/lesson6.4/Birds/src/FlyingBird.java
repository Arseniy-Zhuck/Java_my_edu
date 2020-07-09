public abstract class FlyingBird extends Bird{
    public FlyingBird(String name) {
        super(name);
    }

    public FlyingBird(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void move() {
        fly(1000.0);
    }
    public void fly(double meters) {
        System.out.println("flying " + meters + " meters");
    }

    public void flyAway() {
        System.out.println("i'm flying to Bagamas");
    }

}
