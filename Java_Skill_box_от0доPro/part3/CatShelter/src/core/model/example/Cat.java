package core.model.example;

import java.util.Date;

public class Cat
{

    private static double minWeight = 1000.0;
    private static double maxWeight = 9000.0;


    private double originWeight;
    private double weight;
    private String name;
    private boolean isDead;
    private CatState state;
    private boolean isOur;
    private String owner;
    private Date deathDate;
    private Date giveDate;





    public Cat(String name)
    {
        this(1500.0 + 3000.0 * Math.random(),name);

    }

    public Cat(double weight, String name){
        this.name = name;
        this.weight = weight;
        originWeight = weight;
    }


    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public String toString(){
        return state.toStr();
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