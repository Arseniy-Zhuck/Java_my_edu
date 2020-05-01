import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_class {

    public static int max(int a,int b,int c)
    {
        if (a>b && a>c)
        {
            return a;
        }
        else    if (b>c)
                {
                    return b;
                }
                else return c;
    }

    public static int min(int a,int b,int c)
    {
        if (a<b && a<c)
        {
            return a;
        }
        else    if (b<c)
        {
            return b;
        }
        else return c;
    }

    public static double av(int a,int b, int c)
    {
        return (a+b+c)/3;
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println("Please enteger the first age");
        Integer firstAge = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
        System.out.println("Please enteger the second age");
        Integer secondAge = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
        System.out.println("Please enteger the third age");
        Integer thirdAge = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());

        System.out.println("Min = "+min(firstAge,secondAge,thirdAge));
        System.out.println("Max = "+max(firstAge,secondAge,thirdAge));
        System.out.println("Av = "+av(firstAge,secondAge,thirdAge));

    }
}
