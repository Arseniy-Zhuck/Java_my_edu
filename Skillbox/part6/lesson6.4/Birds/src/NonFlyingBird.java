public abstract class NonFlyingBird extends Bird {
    public NonFlyingBird(String name) {
        super(name);
    }

    public NonFlyingBird(String name, Double weight) {
        super(name, weight);
    }

    @Override
    public void move() {
        run(1000.0);
    }


}
