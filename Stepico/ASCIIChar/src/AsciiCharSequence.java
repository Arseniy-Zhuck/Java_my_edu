import java.lang.reflect.Array;
import java.util.Arrays;

public class AsciiCharSequence implements CharSequence{
    private byte[] byteArray;

    public AsciiCharSequence(byte[] bAr) {
        byteArray = bAr;
    }

    @Override
    public int length() {
        return byteArray.length;
    }

    @Override
    public char charAt(int index) {
        return (char) byteArray[index];
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {

        return new AsciiCharSequence(Arrays.copyOfRange(byteArray,start,end));

    }

    @Override
    public String toString() {
        StringBuilder s=new StringBuilder();
        for (int i = 0; i < length(); i++) {
            s = s.append((char)byteArray[i]);
        }
        return s.toString();
    }

    public byte[] getByteArray() {
        return byteArray;
    }

}
