public class Hen extends NonFlyingBird{

    public Hen(String name) {
        super(name);
    }

    public Hen(String name, double weight) {
        super(name, weight);
    }

    private void dabGrains() {
        System.out.println("Dabbing grain");
    }

    @Override
    public void eat() {
        dabGrains();
        super.eat();
    }

    @Override
    public void voice() {
        System.out.println("ko-ko-ko");
        super.voice();
    }


}
