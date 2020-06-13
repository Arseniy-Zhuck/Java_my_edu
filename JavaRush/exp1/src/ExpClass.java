

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.System.*;
/*
Проверка на упорядоченность
*/
public class ExpClass {
    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(bR.readLine());
        }
        int i = 1;
        boolean res = true;
        while (res&&(i < list.size())) {
            res &= (list.get(i-1).length()<=list.get(i).length());
            i++;
        }
        if (!res) out.println(i-1);
        //напишите тут ваш код
    }
}