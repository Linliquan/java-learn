package t1;

public class E {


    public static final String ABC = "abc";

    public static void main(String[] args) {

        A a = new A();
        System.out.println(a.age);
        f(ABC);

    }

    private static void f(String abc) {
        System.out.println(abc);
    }
}
