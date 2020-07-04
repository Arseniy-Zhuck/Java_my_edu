public class FlyingBird extends Bird{
    public FlyingBird(String name) {
        super(name);
    }

    public void fly(double meters) {
        System.out.println("flying " + meters + " meters");
    }

    public void flyAway() {
        System.out.println("i'm flying to Bagamas");
    }

}
