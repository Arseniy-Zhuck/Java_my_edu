import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class[] interfaces = HashMap.class.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println(interfaces[i].getName());
        }
        Class parent = String.class.getSuperclass();
        System.out.println(parent.getName());
        Method[] methods = List.class.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " " + Arrays.toString(method.getParameters()) + " " + method.getReturnType());
        }
        String s = String.class.newInstance();
        Method m = String.class.getMethod("length");
        int length = (int) m.invoke(s);
        System.out.println(length);
        Object object = new Object();
        //object.
    }
}
