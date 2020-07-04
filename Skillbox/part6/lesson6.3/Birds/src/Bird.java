public abstract class Bird {
    private String name;
    public Bird(String name) {
        this.name = name;
    }

    public void walk(double mm) {
        System.out.println("walking " + mm + " mm");
    }

    public void run(double m) {
        System.out.println("running " + m + " meters");
    }

    protected void eat() {
        System.out.println("eating");
    }

    @Override
    public String toString() {
        return name + " is a " + this.getClass().getName();
    }

}
