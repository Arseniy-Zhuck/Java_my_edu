
public class Cat
{
    private static int catCount = 0;

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double eatAmount;

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

    public double getEatAmount() {
        return eatAmount;
    }

    public void pee() {
        weight-=200;
        System.out.println("Soon you smell it");
    }

    public void meow() {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount) {
        eatAmount += amount;
        weight = weight + amount;
    }

    public void drink(Double amount) {
        weight = weight + amount;
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if(weight < minWeight) {
            catCount--;
            return "Dead";
        }
        else if(weight > maxWeight) {
            catCount--;
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