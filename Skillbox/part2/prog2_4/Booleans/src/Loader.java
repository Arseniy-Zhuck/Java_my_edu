
public class Loader
{
    public static void main(String[] args)
    {
        Integer milkAmount = 200; // ml
        Integer powderAmount = 5; // g
        Integer eggsCount = 3; // items
        Integer sugarAmount = 5; // g
        Integer oilAmount = 30; // ml
        Integer appleCount = 8;

        //powder - 400 g, sugar - 10 g, milk - 1 l, oil - 30 ml
        if (powderAmount>=400 && sugarAmount>=10 &&  milkAmount>=1000 && oilAmount>=30)
        {
            System.out.println("Pancakes");
        }
        else if (milkAmount >= 300 && powderAmount >= 5 && eggsCount >= 5) {//milk - 300 ml, powder - 5 g, eggs - 5
                System.out.println("Omelette");
            } else
                System.out.println((appleCount >= 3 && milkAmount >= 100 && powderAmount >= 300 && eggsCount >= 4) ? "Apple pie" : "I only can make the pelmeni)))");


    }
}