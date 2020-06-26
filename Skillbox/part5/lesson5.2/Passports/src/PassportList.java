import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

public class PassportList {
    private ArrayList<Passport> passports;

    public PassportList() throws IOException, ParseException {
        Passport.setRegions();
        initialize();

    }

    private void initialize() throws IOException, ParseException {
        try {
            passports = FileWorker.readPassports();
        } catch (FileNotFoundException e) {
            passports = new ArrayList<>();
        }
    }

    public boolean contains(Passport passport) {
        return passports.contains(passport);
    }

    public void addPassport(Passport passport) {
        passports.add(passport);
    }

    public void printFake() {
        for (Passport passport : passports) {
            if (passport.isFake()) System.out.println(passport.wholePassport());
        }
    }

    public Passport getPassportBySeriaNumber(Passport passport) {
        return passports.get(passports.indexOf(passport));
    }

    public void deleteFake() {
        Iterator<Passport> iterator = passports.iterator();
        while (iterator.hasNext()) {
            Passport passport = iterator.next();
            if (passport.isFake()) iterator.remove();
        }
    }

    public void printAll() {
        for (Passport passport : passports) {
            System.out.println(passport);
        }
    }

    public void savePassports() {
        FileWorker.writePassports(passports);
    }

}
