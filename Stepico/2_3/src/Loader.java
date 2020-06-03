import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





public class Loader {




    public static boolean isPolyndrom(String s) {
        String s1= s.toLowerCase();
        char[] a=s1.toCharArray();
        char[] b= new char[a.length];
        int l=0;
        for (int i=0;i<a.length;i++) {
            if (((a[i]>='a')&&(a[i]<='z'))||
                    ((a[i]>='0')&&(a[i]<='9'))){
                b[l++]=a[i];
            }
        }
        boolean flag=true;
        for (int i=0;i<l/2;i++) {
            flag &= (b[i]==b[l-1-i]);
        }
        System.out.println(b);
        return flag;
    }

    public static void main(String[] args) throws IOException {
        String s1="A"+('\t'+'\u0003');
        String s2= 'A'+"12";
        String s3= 'A'+'1'+"2";
        String s4= "A"+12;
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        String s = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        System.out.println(isPolyndrom(s));
    }
}
