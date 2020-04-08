package O2;

public class B extends A {


    public String show(B b){
        return "B and B";
    }


    public String show(A a){
        return "B and A";
    }

    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        System.out.println(a.show(b));

    }
}
