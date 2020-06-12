
public class Cat
{
    private static int catCount = 0;

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double eatAmount;
    private CatState catState;
    //private boolean isDead = false;

    public static int getCatCount() {
        return Cat.catCount;
    }


    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        eatAmount = 0;
        catCount++;
        this.catState = new CatAliveState();
        this.catState.setCat(this);
    }

    private void die() {
        Cat.catCount--;
        System.out.println("The cat is dead");
        this.catState = new CatDeadState();
    }

    private void check() {
        if ((getStatus().equals("Dead"))||(getStatus().equals("Exploded"))) {
            die();
        }
    }

    public double getEatAmount() {
        return eatAmount;
    }

    public void pee() {
        catState.pee();
    }

    public void meow() {
        catState.meow();
    }

    public void feed(Double amount) {
        catState.feed(amount);
    }

    public void drink(Double amount) {
        catState.drink(amount);
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if(weight < minWeight) {

            return "Dead";
        }
        else if(weight > maxWeight) {

            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    @Override
    public String toString() {
        return "cat of weight " + this.weight + " is " + getStatus();
    }



    private class CatAliveState implements CatState{
        private Cat cat;

        @Override
        public void feed(double amount) {
            cat.eatAmount += amount;
            cat.weight = weight + amount;
            cat.check();
        }

        @Override
        public void drink(double amount) {
            weight = weight + amount;
            check();
        }

        @Override
        public void meow() {
            weight = weight - 1;
            System.out.println("Meow");
            check();
        }

        @Override
        public void pee() {
            weight -= 200;
            System.out.println("Soon you smell it");
            check();
        }

        @Override
        public void setCat(Cat cat) {
            this.cat = cat;
        }
    }

    private class CatDeadState implements CatState{

        @Override
        public void feed(double amount) {
            System.out.println("Dead cats don't eat");
        }

        @Override
        public void drink(double amount) {
            System.out.println("Dead cats don't drink");
        }

        @Override
        public void meow() {
            System.out.println("Dead cats don't meow");
        }

        @Override
        public void pee() {
            System.out.println("Dead cats don't go pee");
        }

        @Override
        public void setCat(Cat cat) {

        }
    }

}