
public class Cat
{
    private static int catCount = 0;

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double eatAmount;
    private boolean isDead = false;

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
    }

    private void die() {
        Cat.catCount--;
        isDead = true;
        System.out.println("The cat is dead");
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
        if (!isDead) {
            weight -= 200;
            System.out.println("Soon you smell it");
            check();
        } else System.out.println("Dead cats don't go pee");
    }

    public void meow() {
        if (!isDead) {
            weight = weight - 1;
            System.out.println("Meow");
            check();
        } else System.out.println("Dead cats don't meow");

    }

    public void feed(Double amount) {
        if (!isDead) {
            eatAmount += amount;
            weight = weight + amount;
            check();
        } else System.out.println("Dead cats don't eat");
    }

    public void drink(Double amount) {
        if (!isDead) {
                weight = weight + amount;
                check();
        } else System.out.println("Dead cats don't drink");
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
}