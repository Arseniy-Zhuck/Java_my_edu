package core;

import java.util.HashSet;

/**
 * Created by Danya on 24.08.2015.
 */
public class Police
{
    // почему static тут могу лишь догадываться о мыслях того кто это писал
    // первая логичная мысль быстрее всего именно так написать и меньше геммороя не делать объекты
    // если же искать скрытый смысл могу придумать такое объяснения
    // из других классов и объектов программы мы не меняем внутренне устройство полиции мы его вообще по факту не знаем
    // нам не нужно знать текущее состояние участков и управлений
    // нам не нужно менять эти состояния
    // не нужно выбирать кокретный участок для работы с только ним например
    // нам в проге от полиции нужно 3 действия, а на их внутреннюю кухню нам начхать исходя из таких рассуждений
    // первая логичная мысль быстрее всего static написать и меньше геммороя не делать объекты


    // поля private инкапсуляция, все хорошо
    private static Boolean called = false;
    private static HashSet<String> criminalNumbers;

    // public чтобы было доступно из RoadController::main
    public static HashSet<String> getCriminalNumbers()
    {
        if(criminalNumbers != null) {
            return criminalNumbers;
        }
        criminalNumbers = new HashSet<>();
        Integer count = (int) (200 * Math.random());
        for(Integer i = 0; i < count; i++)
        {
            String randomNumber = Double.toString(Math.random()).substring(2, 5);
            criminalNumbers.add(randomNumber);
        }
        return criminalNumbers;
    }

    // public чтобы было доступно из RoadController::main
    public static void call(String message)
    {
        called = true;
        System.out.println("Вызов полиции... Причина: " + message);
    }

    // public чтобы было доступно из RoadController::main
    public static Boolean wasCalled()
    {
        return called;
    }

    //=======================================

    // вызывается из Camera::getNextCar то есть из того же пакета значит без модификатора доступа
    static void resetCalled()
    {
        called = false;
    }
}
