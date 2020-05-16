
public class Cat
{
    private static Cat cat;
    private Double originWeight;
    private Double weight;
    private Double eaten;
    private static Double minWeight;
    private static Double maxWeight;
    private String name;
    private Integer actCount;

    public static Cat getCat() {
        if (cat == null) {
            minWeight = 1000.0;
            maxWeight = 9000.0;
            cat = new Cat();
        }
        return cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        name = userName;
    }

    public static Double getDif(){
        return (maxWeight-minWeight);
    }



    private Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        eaten = 0.0;
        actCount=0;
    }

    public int getActCount(){
        return actCount;
    }


    public Double getEaten() {
        return eaten;
    }

    public void toilet() {
        weight -= 200.0;
        actCount++;
        System.out.println("Now it's allright");
    }


    public void meow() {
        weight = weight - 1;
        actCount++;
        System.out.println("Meow");
    }

    public void feed(Double amount) {
        eaten += amount;
        weight = weight + amount;
        actCount++;
    }

    public void drink(Double amount) {
        weight = weight + amount;
        actCount++;
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
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