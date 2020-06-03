
public class Cat
{
    private Double originWeight;
    private Double weight;
    private boolean isKitten;
    private Double minWeight;
    private Double maxWeight;
    private static int count=0;

    // private class methods
    private static void incCount() {
        count++;
    }

    private static void decCount() {
        count--;
    }

    public static int getCount() {
        return count;
    }


    //public class methods
    public static Cat getCat() {
        incCount();
        return new Cat();
    }

    public static Cat getCat(double weight) {
        incCount();
        return new Cat(weight,weight,buildParams(weight));
    }

    private static boolean buildParams(double weight) {
        return weight<1000;
    }

    
    // constructors
    private Cat(double weight, double weightKitten, boolean isKitten) {
        this.isKitten=isKitten;
        this.weight= this.kit() ? weightKitten : weight;
        setMinMax();
    }

    private Cat() {
        this(1500.0 + 3000.0 * Math.random(),Math.random()*100.0+100.0,Math.random()>0.5);
    }


    // private instance methods
    private void setMinMaxKitten() {
        minWeight = 100.0;
        maxWeight = 1000.0;
    }

    private void setMinMaxCat() {
        minWeight = 1000.0;
        maxWeight = 9000.0;
    }

    private void setMinMax() {
        if (isKitten) {
            setMinMaxKitten();
        } else {
            setMinMax();
        }
    }

    private void die() {
        System.out.println("It's dead");
        decCount();
    }

    private void growUp() {
        setMinMaxCat();
    }

    private void check(){
        if ((this.getStatus().equals("Dead"))||(this.getStatus().equals("Exploded"))) {
            this.die();
        } else if (this.getStatus().equals("GrownUp")) {
            this.growUp();
        }
    }



    // public instance methods
    public void meow() {
        System.out.println("Meow");
        weight = weight - 1;
        check();
    }

    public boolean kit(){
        return isKitten;
    }

    public void feed(Double amount) {
        weight = weight + amount;
        check();
    }

    public void drink(Double amount) {
        weight = weight + amount;
        check();
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus()
    {
        if (isKitten) {
            if(weight < minWeight) {
                return "Dead";
            } else if(weight > 2*maxWeight) {
                return "Exploded";
            } else if (weight > maxWeight) {
                return "GrownUp";
            } else if(weight > originWeight) {
                return "Sleeping";
            } else {
                return "Playing";
            }
        } else {
            if(weight < minWeight) {
                return "Dead";
            } else if(weight > maxWeight) {
                return "Exploded";
            } else if(weight > originWeight) {
                return "Sleeping";
            } else {
                return "Playing";
            }
        }


    }
}