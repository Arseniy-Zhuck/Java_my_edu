import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Passports {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
//        String[] series = new String[85*23];
//        int k = 0;
//        int[] regions = new int[85];
//        File file = new File(".\\src\\regions.txt");
//        //создаем объект FileReader для объекта File
//        FileReader fr = new FileReader(file);
//        //создаем BufferedReader с существующего FileReader для построчного считывания
//        BufferedReader reader = new BufferedReader(fr);
//        // считаем сначала первую строку
//        //String englishText = "";
//        String line = reader.readLine();
//        int reg = 0;
//        while ((line != null)&&(line != "")) {
//            regions[reg++] = Integer.parseInt(line);
//            line = reader.readLine();
//        }
//        for (int i = 0; i < 85; i++) { // номера регионов России
//                String s;
//                if (regions[i] < 10) s = "0" + i; // чтобы 03,04 сделать
//                else s = String.valueOf(regions[i]);
//                s += " ";
//                for (int j = 97; j < 100; j++) {
//                    String s1 = String.valueOf(j);
//                    series[k++] = s + s1;
//                }
//                for (int j = 0; j < 20; j++) {
//                    String s1;
//                    if (j < 10) s1 = "0" + j;
//                    else s1 = String.valueOf(j);
//                    series[k++] = s + s1;
//                }
//
//        }
//        for (int i = 0; i < 85*23; i++) {
//            System.out.println(series[i]);
//        }
        System.out.println("Wellcome to our passport table");
        System.out.println("\"Flash, flash, hundred yard dash\"");
        //Passport.setRegions();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PassportList passportList = null;
        try {
            passportList = new PassportList();
        } catch (FileNotFoundException e) {
            System.out.println("NO REGIONS FILE");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error while readeing regions");
            System.exit(0);
        }
        while (true) {
            System.out.println("Please, type command LIST, EXIT, LISTFAKES, GETINFO or start writing FIO");
            String command = bufferedReader.readLine();
            if (command.equals("LIST")) {
                passportList.printAll();
                continue;
            }
            if (command.equals("EXIT")) {
                System.out.println("Зи");
                Thread.sleep(1000);
                System.out.println("но");
                Thread.sleep(1000);
                System.out.println("чка");
                Thread.sleep(1000);
                System.out.println("Какой");
                Thread.sleep(1000);
                System.out.println("верблюд");
                Thread.sleep(1000);
                System.out.println("трехгорбый?");
                Thread.sleep(5000);
                System.out.println("Беременный");
                Thread.sleep(3000);
                System.out.println("ХА");
                Thread.sleep(3000);
                System.out.println("ХА");
                Thread.sleep(1000);
                System.out.println("ХА");
                passportList.savePassports();
                break;
            }
            if (command.equals("LISTFAKES")) {
                passportList.printFake();
                String answer = "";
                while (!((answer.equals("y"))|(answer.equals("n")))) {
                    System.out.println("Do you wanna delete fakes? y/n");
                    answer = bufferedReader.readLine();
                }
                if (answer.equals("y")) passportList.deleteFake();
                continue;
            }
            if (command.equals("GETINFO")) {
                boolean seriaCorrect = false;
                String seria = "";
                while (!seriaCorrect) {
                    System.out.println("Print seria correctly XXXX");
                    seria = bufferedReader.readLine();
                    seriaCorrect = Passport.checkseria(seria);
                }
                boolean numberCorrect = false;
                String number = "";
                while (!numberCorrect) {
                    System.out.println("Print number correctly XXXXXX");
                    number = bufferedReader.readLine();
                    numberCorrect = Passport.checknumber(number);
                }
                Passport passportForSearch = new Passport(seria, number);
                System.out.println(passportList.contains(passportForSearch) ?
                        passportList.getPassportBySeriaNumber(passportForSearch) :
                        "There is no such passport");
                continue;
            }

            String FIO = command;
            boolean correctFIO = Passport.checkFIO(FIO);
            while (!correctFIO) {
                System.out.println("Type FIO Correctly");
                FIO = bufferedReader.readLine();
                correctFIO = Passport.checkFIO(FIO);
            }

            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = null;
            boolean correctDateOfBirth = false;
            while (!correctDateOfBirth) {
                System.out.println("Type date of birth in dd.MM.yyyy format correctly");
                String s = bufferedReader.readLine();
                try {
                    date = dateFormat.parse(s);
                } catch (ParseException e) {
                    System.out.println("format is not correct");
                    continue;
                }
                correctDateOfBirth = Passport.checkBirthDate(date);
            }

            String region = null;
            boolean correctRegion = false;
            while (!correctRegion) {
                System.out.println("Type region correctly");
                region = bufferedReader.readLine();
                correctRegion = Passport.checkRegion(region);
            }

            System.out.println("Type address");
            String address = bufferedReader.readLine();

            DateFormat passportDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date passportDate = null;
            System.out.println("Do you wanna use current date? y/*");
            String currentDateAnswer = bufferedReader.readLine();
            if (currentDateAnswer.equals("y")) {
                passportDate = new Date();
            } else {
                boolean correctDateOfPassport = false;
                while (!correctDateOfPassport) {
                    System.out.println("Type date of passport getting in dd.MM.yyyy format correctly");
                    String s = bufferedReader.readLine();
                    try {
                        passportDate = dateFormat.parse(s);
                        correctDateOfPassport = true;
                    } catch (ParseException e) {
                        System.out.println("format is not correct");
                        continue;
                    }
                }
            }
            boolean seriaAutomatic = false;
            String seria = "";
            System.out.println("Do you wanna build seria automatically y/*");
            String seriaAutoAnswer = bufferedReader.readLine();
            if (seriaAutoAnswer.equals("y")) {
                seriaAutomatic = true;
            } else {
                boolean seriaCorrect = false;

                while (!seriaCorrect) {
                    System.out.println("Print seria correctly XXXX");
                    seria = bufferedReader.readLine();
                    seriaCorrect = Passport.checkseria(seria);
                }
            }
            boolean numberCorrect = false;
            String number = "";
            while (!numberCorrect) {
                System.out.println("Print number correctly XXXXXX");
                number = bufferedReader.readLine();
                numberCorrect = Passport.checknumber(number);
            }

            if (seriaAutomatic) {
                passportList.addPassport(new Passport(
                        FIO,
                        region,
                        address,
                        number,
                        passportDate,
                        date
                ));
            } else {
                passportList.addPassport(new Passport(
                        seria,
                        number,
                        passportDate,
                        FIO,
                        date,
                        region,
                        address
                ));
            }
        }

    }
}
