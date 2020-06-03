
public class Cat
{   // у меня кончилась фантазия, поэтому просто выполненное задание
    private Double originWeight;
    private Double weight;
    private static Double minWeight = 1000.0;
    private static Double maxWeight = 9000.0;
    private static int count=0;

    private static void incCount() {
        count++;
    }

    private static void decCount() {
        count--;
    }

    public static int getCount() {
        return count;
    }

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        incCount();
    }

    private void die() {
        System.out.println("It's dead");
        decCount();
    }

    public void meow()
    {
        System.out.println("Meow");
        weight = weight - 1;
        check("Dead");
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
         check("Exploded");
    }

    private void check(String status){
        if (this.getStatus().equals(status)) {
            this.die();
        }
    }


    public void drink(Double amount)
    {
        weight = weight + amount;
        check("Exploded");
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
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
}