public class Main {

    public static void task01() {
        int a = 0;
        int b = (byte) a + 46;
        System.out.println(b);
        byte c = (byte) (a * b);
        System.out.println(c);
        double f = (char) 1234.15;
        System.out.println(f);
        long d = (long) (a + f / c + b);
        System.out.println(d);
    }

    public static void task02() {
        int a = 15;
        int b = 4;
        float c = (float)a / b;
        System.out.println(c);
        double d = a * 1e-3 + c;
        System.out.println(d);
    }

    public static void task04() {
        short number = (char)9;
        System.out.println(number);
        char zero = (int)'0';

        System.out.println((int) zero);
        int nine = (zero + number);
        System.out.println((char) nine);
    }

    public static void task06() {
        double d = (short) 2.50256e2d;
        System.out.println(d);
        char c = (short) 'd';
        System.out.println((int) c);
        short s = (short) 2.22;
        System.out.println(s);

        int i = 150000;
        System.out.println(i);
        float f =  0.50f;
        System.out.println(f);
        double result = f + (i / c) - (d * s) - 500e-3;
        System.out.println("result: " + result);
    }

    public static void task07() {
        long l = 1234_564_890L;
        System.out.println(l);
        int x =  0b1000_1100_1010;
        System.out.println(x);
        double m = (byte) 110_987_654_6299.123_34;
        System.out.println(m);
        float f =  l++ + 10 + ++x - (float) m;
        System.out.println(f);
        l = (long) f / 1000;
        System.out.println(l);
    }


    public static void main(String[] args) {
        //task01();
        task07();
    }

}
