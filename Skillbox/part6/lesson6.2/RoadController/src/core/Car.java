package core;
// public так используется в куче классов и должно быть доступно
public class Car
{
    //  поля должны быть private инкапсуляция
    // обращение к полям только через методы
    private String number;
    private Integer height;
    private Double weight;
    private Boolean hasVehicle;
    private Boolean isSpecial;

    // конструктор в Camera вызывается значит по идее можно default вместо public
    public Car(String carNumber, Integer carHeight, Double carWeight, Boolean carHasVehicle)
    {
        number = carNumber;
        height = carHeight;
        weight = carWeight;
        hasVehicle = carHasVehicle;
        isSpecial = false;
    }

    // геттеры cеттеры public все логично
    //=========================================================================

    public void setIsSpecial()
    {
        isSpecial = true;
    }

    //=========================================================================

    public String getNumber()
    {
        return number;
    }

    public Integer getHeight()
    {
        return height;
    }

    public Boolean isSpecial()
    {
        return isSpecial;
    }

    public Boolean hasVehicle()
    {
        return hasVehicle;
    }

    //=========================================================================

    // вызывается из WeightMeter того же пакета, значит идентификатор доступа по умолчанию
    Double getWeight()
    {
        return weight;
    }

    //=========================================================================
    // toString Public  у Object, мы его переопределяем, но мы не можем сделать идентификатор доступа
    // более закрытым чем у родителя, мы можем только ослабить значит так как toString public у Object
    // здесь у нас нет выбора
    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}