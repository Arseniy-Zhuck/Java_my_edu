import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<MyClass> arrayList = new ArrayList<>();
        arrayList.add(new MyClass("1","1","1","1"));
        arrayList.add(new MyClass("2","2","2","2"));
        arrayList.add(new MyClass("3","3","3","3"));
        arrayList.add(new MyClass("4","4","4","4"));
        System.out.println(arrayList.contains(new MyClass("3","3")));
        System.out.println(arrayList.get(arrayList.indexOf(new MyClass("4","4"))));
    }
}
