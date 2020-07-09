public class Frog implements Vertebrate{
    private String name;
    private Double weight;

    public Frog(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Frog(String name) {
        this(name, 100 + Math.random()*1000);
    }

    public void jump() {
        System.out.println("Jump --- jump --- jump");
    }

    private void catchFly() {
        System.out.println("Fucking fly will die");
    }


    @Override
    public void move() {
        for (int i = 0; i < 10; i++) {
            jump();
        }
    }

    @Override
    public void moveForALittle() {
        jump();
    }

    @Override
    public void eat() {
        catchFly();
        System.out.println("tasty fly");
    }

    @Override
    public void voice() {
        System.out.println("qua-qua-qua");
        System.out.println(this);
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Vertebrate o) {
        return (int) Math.round(this.getWeight() - o.getWeight());
    }
    @Override
    public String toString() {
        return name + " is a " + this.getClass().getName() +
                " of weight " + this.getWeight() + " gramms";
    }

}
