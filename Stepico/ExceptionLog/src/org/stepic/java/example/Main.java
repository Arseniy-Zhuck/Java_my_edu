package org.stepic.java.example;
public class Main {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }
    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        IllegalArgumentException ill = new IllegalArgumentException();
        if (ill.getStackTrace().length<3) return null;
        else {
            String s = ill.getStackTrace()[2].toString();
            String ss = s.replaceAll("\\([^,]+\\)","");
            int i = ss.lastIndexOf(".");
            char[] chars = ss.toCharArray();
            chars[i] = '#';
            String sss = String.copyValueOf(chars);
            return sss;
        }
    }

}
