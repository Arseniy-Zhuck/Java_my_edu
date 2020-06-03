import core.*;
import core.Camera;

public class RoadController
{
    // отсюда и до строки 20 переменные, точнее аттрибуты, а вот тут не знаю, класса или объекта
    public static double passengerCarMaxWeight = 3500.0; // kg Double passengerCarMaxWeight
    public static int passengerCarMaxHeight = 2000; // mm Integer passengerCarMaxHeight
    public static int controllerMaxHeight = 4000; // mm Integer controllerMaxHeight

    public static int passengerCarPrice = 100; // RUB Integer passengerCarPrice
    public static int cargoCarPrice = 250; // RUB Integer cargoCarPrice
    public static int vehicleAdditionalPrice = 200; // RUB Integer vehicleAdditionalPrice

    public static int maxOncomingSpeed = 30; // km/h Integer maxOncomingSpeed
    public static int speedFineGrade = 20; // km/h Integer speedFineGrade
    public static int finePerGrade = 500; // RUB
    public static int criminalSpeed = 160; // km/h

    public static void main(String[] args)
    {
        for(int i = 0; i < 10; i++)
        {
            Car car = Camera.getNextCar(); // тут инициализация объекта, это надо писать?
            System.out.println(car);
            System.out.println("Скорость: " + Camera.getCarSpeed(car) + " км/ч");

            /**
             * Пропускаем автомобили спецтранспорта
             */
            if(car.isSpecial()) {
                openWay();
                continue;
            }

            /**
             * Проверка на наличие номера в списке номеров нарушителей
             */
            boolean policeCalled = false; // о вот тут переменная типа boolean под название policeCalled
            for(String criminalNumber : Police.getCriminalNumbers())
            {
                String carNumber = car.getNumber(); // переменная carNumber типа String
                if(carNumber.equals(criminalNumber)) {
                    Police.call("автомобиль нарушителя с номером " + carNumber);
                    blockWay("не двигайтесь с места! За вами уже выехали!");
                    break;
                }
            }
            if(Police.wasCalled()) {
                continue;
            }

            /**
             * Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
             */
            int carHeight = car.getHeight(); // перемнная carHeight типа Integer
            int price = 0; // переменная price типа Integer
            if(carHeight > controllerMaxHeight)
            {
                blockWay("высота вашего ТС превышает высоту пропускного пункта!");
                continue;
            }
            else if(carHeight > passengerCarMaxHeight)
            {
                Double weight = WeightMeter.getWeight(car);
                //Грузовой автомобиль
                if(weight > passengerCarMaxWeight)
                {
                    price = passengerCarPrice;
                    if(car.hasVehicle()) {
                        price = price + vehicleAdditionalPrice;
                    }
                }
                //Легковой автомобиль
                else {
                    price = cargoCarPrice;
                }
            }
            else {
                price = passengerCarPrice;
            }

            /**
             * Проверка скорости подъезда и выставление штрафа
             */
            int carSpeed = Camera.getCarSpeed(car); //переменная carSpeed integer
            if(carSpeed > criminalSpeed)
            {
                Police.call("cкорость автомобиля - " + carSpeed + " км/ч, номер - " + car.getNumber());
                blockWay("вы значительно превысили скорость. Ожидайте полицию!");
                continue;
            }
            else if(carSpeed > maxOncomingSpeed)
            {
                int overSpeed = carSpeed - maxOncomingSpeed; // перемнная overspeed типа Integer
                int totalFine = finePerGrade * (1 + overSpeed / speedFineGrade); // переменная totalfine типа integer
                System.out.println("Вы превысили скорость! Штраф: " + totalFine + " руб.");
                price = price + totalFine;
            }

            /**
             * Отображение суммы к оплате
             */
            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }

    }

    /**
     * Открытие шлагбаума
     */
    public static void openWay()
    {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    public static void blockWay(String reason)
    {
        System.out.println("Проезд невозможен: " + reason);
    }
}