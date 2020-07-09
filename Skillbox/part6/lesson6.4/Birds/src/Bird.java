public abstract class Bird implements Vertebrate{
    private String name;
    private double weight;

    public Bird(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Bird(String name) {
        this(name, 100 + Math.random()*1000);
    }

    public void walk(double mm) {
        System.out.println("walking " + mm + " mm");
    }

    public void run(double m) {
        System.out.println("running " + m + " meters");
    }

    public void eat() {
        System.out.println("eating");
    }

    @Override
    public void moveForALittle() {
        walk(1000);
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Vertebrate vertebrate) {
        return (int) Math.round(this.weight - vertebrate.getWeight());
    }

    @Override
    public String toString() {
        return name + " is a " + this.getClass().getName() +
                " of weight " + this.getWeight() + " gramms";
    }

    @Override
    public void voice() {
        System.out.println(this);
    }

}
