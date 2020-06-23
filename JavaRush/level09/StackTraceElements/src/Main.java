public class Main {
    public static void main(String[] args) {

        System.out.println(method1());
    }

    public static String method1() {
        System.out.println(method2());
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getMethodName();
        //напишите тут ваш код
    }

    public static String method2() {
        System.out.println(method3());
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getMethodName();

        //напишите тут ваш код
    }

    public static String method3() {
        System.out.println(method4());
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getMethodName();

        //напишите тут ваш код
    }

    public static String method4() {
        System.out.println(method5());
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getMethodName();

        //напишите тут ваш код
    }

    public static String method5() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getMethodName();

        //напишите тут ваш код
    }
}
