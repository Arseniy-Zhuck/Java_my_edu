public class Hen extends NonFlyingBird{

    public Hen(String name) {
        super(name);
    }

    private void dabGrains() {
        System.out.println("Dabbing grain");
    }

    @Override
    public void eat() {
        dabGrains();
        super.eat();
    }


}
