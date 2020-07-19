import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class Passport {
    private String FIO, region,address, seria, number;
    private Date passportDate, birthDate;
    // вопрос 1 хотел сделать вот так но не знаю тогда где писать обработчик исключений и
    // не понимаю когда он сработает собственно пока ошибался в имени файла в подключении была такая проблема
    // плюс я читал, уже не помню где, что обработчики исключения надо стараться делать
    // как можно выше по stacktrace и я запутался, как быть тут, то есть можно внутри этого метода readRegionsPassport()
    // сделать обработчик, но я тогда недопонимаю, когда этот метод будет вызван, то есть что
    // произойдет в программе. Во время экспериментов получилось, что при создании первого экземпляра пасспорт
    // и он вывел целую кучу cause в которых я запутался
    // ну и плюс сам readRegionsPassport() выглядел в этом случае как какое-то чудовище
    // так как ни одно исключение нельзя было пробросить наверх
    // ну и в связи с этим вопрос, как определить static константу, если она получается методом,
    // кидающим исключения, одно из которых для меня важно и я хочу его обработать
    // и она обязана быть static, не строить же мапу для каждого объекта
    private static Map<String, String> REGIONS_PASSPORT;


    private static String getCodeByRegion(String region) {
        String res = "";
        boolean flag = false;
        Iterator<Map.Entry<String, String>> iterator = REGIONS_PASSPORT.entrySet().iterator();
        while ((!flag) && (iterator.hasNext())) {
            Map.Entry<String, String> node = iterator.next();
            flag =node.getValue().equals(region);
            res = node.getKey();
        }
        return res;
    }

    public static boolean checkRegion(String region) {
        return REGIONS_PASSPORT.containsValue(region);
    }

    public static void setRegions() throws IOException {
       REGIONS_PASSPORT = FileWorker.readRegionsPassport();
    }

    public static boolean checkFIO(String maybeFIO) {
        return Pattern.compile("[А-ЯЁ&&[^ЪЬЫ]][а-яё]+\\s[А-ЯЁ&&[^ЪЬЫ]][а-яё]+\\s" +
                "[А-ЯЁ&&[^ЪЬЫ]][а-яё]+$").matcher(maybeFIO).matches();
    }

    public static boolean checkBirthDate(Date birthDate) {
        return (System.currentTimeMillis() - birthDate.getTime()) / 1000 / 60 / 60 / 24 / 365 > 18;
    }

    public static boolean checkseria(String s) {
        String s1 = s.substring(0,2);
        String s2 = s.substring(2);
        return REGIONS_PASSPORT.containsKey(s1)&&Pattern.compile("[901][0-9]").matcher(s2).matches();
    }

    public static boolean checknumber(String s) {
        return Pattern.compile("[0-9]{6}").matcher(s).matches();
    }

    // прошу прощения, кучу методов после уже написал, и коммент сдвинулся((
    // вопрос был по этому методу formSeria
    // и еще у меня ВОПРОС, компилятор ругался, когда этот метод небыл static на его вызов в конструкторе, ПОЧЕМУ?
    private static String formSeria(String region, Date passportDate) {
        int year = passportDate.getYear()%100;
        String s = year < 10 ? "0" + year : "" + year;
        return getCodeByRegion(region) + s;
    }

    private static String getRegionByCode(String regionCode) {
        return REGIONS_PASSPORT.get(regionCode);
    }

    public Passport (String[] lines) throws ParseException {
        this(
                lines[0],
                lines[1],
                (new SimpleDateFormat("dd.MM.yyyy")).parse(lines[2]),
                lines[3],
                (new SimpleDateFormat("dd.MM.yyyy")).parse(lines[4]),
                lines[5],
                lines[6]
        );
    }

    public Passport(String seria, String number, Date passportDate, String FIO, Date birthDate, String region,
                     String address) {
        this(seria, number);
        this.FIO = FIO;
        this.region = region;
        this.address = address;
        this.passportDate = passportDate;
        this.birthDate = birthDate;
    }

    public Passport(String FIO, String region, String address, String number, Date passportDate,
                    Date birthDate) {
        this(formSeria(region, passportDate), // я этот метод вызываю здесь, почему ошибка?
                number,
                passportDate,
                FIO,
                birthDate,
                region,
                address);
    }

    public Passport(String seria, String number) {
        this.seria = seria;
        this.number = number;
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof Passport) {
            return this.hashCode() == anObject.hashCode();
        } else return false;
    }

    @Override
    public int hashCode() {
        return this.seria.hashCode() + this.number.hashCode();
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return FIO + " " + dateFormat.format(birthDate) + " " + region + " " + address;
    }

    public String wholePassport() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return seria + "\t" + number + "\t" + dateFormat.format(passportDate) + "\t" +
                FIO + "\t" + dateFormat.format(birthDate) + "\t" + region + "\t" + address;
    }

    public boolean isFake() {
        boolean regionCorrect = seria.substring(0,2).equals(getCodeByRegion(region));
       // System.out.println(this + " region correct " + regionCorrect);
        boolean dataCorrect;    // дата в серии может быть меньше на 1 или 2, типа прошлогодние серии
                                // или больше на один, типа кончилась куча, заказали еще но
                                // доставка возможна только следующегодних уже,
                                // по крайней мере так в вики написано
        int dataDiff = Integer.parseInt(seria.substring(2)) - passportDate.getYear()%100;
        //System.out.println(seria.substring(2) + " ");
        //System.out.println(this + " data diff" + dataDiff);
        dataCorrect = ((dataDiff > -3)&&(dataDiff < 2))||((dataDiff > 97)&&(dataDiff < -98));
        //System.out.println(this + " data correct " + dataCorrect);
        return !(regionCorrect && dataCorrect);
    }


}
