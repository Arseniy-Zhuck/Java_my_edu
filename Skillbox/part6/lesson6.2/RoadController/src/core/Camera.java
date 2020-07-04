package core;

import java.util.HashMap;
// public чтобы к классу можно было обратиться
public class Camera
{   // static так как основные методы не требуют наличия характеристик камеры, а значит
    // и данное поле будет static чтобы было доступно из методов
    // почему public не понимаю, так же нельзя
    public static HashMap<String, Integer> carsSpeed = new HashMap<>();

    // public чтобы было доступно из RoadController::main
    // статик так как мы не меняем состояние камеры просто получаем машину
    public static Car getNextCar()
    {
        String randomNumber = Double.toString(Math.random()).substring(2, 5);
        Integer randomHeight = (int) (1000 + 3500. * Math.random());
        Double randomWeight = 600 + 10000 * Math.random();
        Car car = new Car(randomNumber, randomHeight, randomWeight, Math.random() > 0.5);
        if(Math.random() < 0.15) {
            car.setIsSpecial();
        }
        Police.resetCalled();

        return car;
    }

    // public чтобы было доступно из RoadController::main
    // статик так как мы не меняем состояние камеры просто получаем машину
    public static Integer getCarSpeed(Car car)
    {
        String carNumber = car.getNumber();
        if(!carsSpeed.containsKey(carNumber)) {
            carsSpeed.put(carNumber, (int) (180 * Math.random()));
        }
        return carsSpeed.get(carNumber);
    }
}