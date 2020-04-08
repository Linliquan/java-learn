package Override;

public class B extends A {


    public  void test(){
        show();
    }


    public void show(){
        System.out.println("B show");
    }


    public static void main(String[] args) {
        A a = new A();
        ((B) a).test();

    }
}
