public class MyClass {
    private String field1,field2,field3,field4;

    public MyClass(String field1, String field2, String field3, String field4) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }

    public MyClass(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    @Override
    public boolean equals(Object anObejct) {
        if (anObejct instanceof MyClass) {
            return this.hashCode()==anObejct.hashCode();
        } else return false;
    }

    @Override
    public int hashCode() {
        return field1.hashCode()+field2.hashCode();
    }

    @Override
    public String toString() {
        return "field3 = " + field3 + ", field4 = " + field4;

    }

}
