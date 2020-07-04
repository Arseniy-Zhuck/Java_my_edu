package core;

/**
 * Created by Danya on 24.08.2015.
 */
public class WeightMeter
{
    // нет никаких полей объекта экземпляр данного класса вообще не нужен
    // но нужен 1 метод поэтому public static

    public static Double getWeight(Car car)
    {
        return car.getWeight();
    }
}