package O3;


public class LJXQ {
    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        // AA AD BA? BA ? ?
        System.out.println(a.get(a) + " - " + a.get(d) + " - " + a.get(b) + " - " + b.get(a) + " - " + b.get(c) + " - "
                + b.get(d));
    }

}

class A {
    String get(D d) {
        return "AD";
    }

    String get(A a) {
        return "AA";
    }
}

class B extends A {
    String get(A a) {
        return "BA";
    }

    String get(B b) {
        return "BB";
    }
}

class C extends B {
}

class D extends B {
}