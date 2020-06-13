import java.nio.CharBuffer;

public class ASCIIChar {
    public static void main(String[] args) {
        CharSequence a = "asdfgh";
        String s = "dfdfdfdf";

        System.out.println(a.subSequence(1,4));
        System.out.println((char)42);
        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(new byte[]{65, 66, 67, 68, 69, 70});
        System.out.println(asciiCharSequence.length());
        System.out.println(asciiCharSequence.charAt(2));
        byte[] b = asciiCharSequence.subSequence(1,4).getByteArray();
        for (int i = 0; i < 3; i++) {
            System.out.println(b[i]);
        }

        System.out.println(asciiCharSequence);
    }
}
