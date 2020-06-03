import java.math.BigDecimal;

public class Loader {
    public static void main(String[] args) {
        double var1=24.0*0.1;
        Short minShort=Short.MIN_VALUE;
        Short maxShort=Short.MAX_VALUE;
        Integer minInteger=Integer.MIN_VALUE;
        Integer maxInteger=Integer.MAX_VALUE;
        Long minLong=Long.MIN_VALUE;
        Long maxLong=Long.MAX_VALUE;
        Float minFloat=Float.MIN_VALUE;
        Float maxFloat=Float.MAX_VALUE;
        Double minDouble=Double.MIN_VALUE;
        Double maxDouble=Double.MAX_VALUE;
        System.out.println("Boring experiments");
        System.out.println(var1);
        System.out.println(minShort);
        System.out.println(maxShort);
        System.out.println(minInteger);
        System.out.println(maxInteger);
        System.out.println(minLong);
        System.out.println(maxLong);
        System.out.println(minFloat);
        System.out.println(maxFloat);
        System.out.println(minDouble);
        System.out.println(maxDouble);
        String[] str = new String[7];
        str[0]="it's very boring task. May i have something more fun? ";
        str[1]=minShort.getClass()+": "+minShort.toString()+" ... "+maxShort.toString();
        str[2]=minInteger.getClass()+": "+minInteger.toString()+" ... "+maxInteger.toString();
        str[3]=minLong.getClass()+": "+minLong.toString()+" ... "+maxLong.toString();
        str[4]=minFloat.getClass()+": "+minFloat.toString()+" ... "+maxFloat.toString();
        str[5]=minDouble.getClass()+": "+minDouble.toString()+" ... "+maxDouble.toString();
        str[6]="The most boring taaask";
        for (String s: str) {
            System.out.println(s);
        }
        System.out.println("URA!!!! HOT\' SHTO-TO");
        BigDecimal bigDec1=BigDecimal.valueOf(24.0);
        BigDecimal bigDec2=BigDecimal.valueOf(0.1);
        BigDecimal bigDecResult=bigDec1.multiply(bigDec2);
        System.out.println(bigDecResult.toString());
    }
}
