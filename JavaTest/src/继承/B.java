package 继承;


/**
 * @author linliquan
 * @description:
 * @create 2021/6/21 16:37
 */
public class B extends A {

    @Override
    public void test() {
        System.out.println("hello BBB");
    }

    public static void main(String[] args) {
        A a = new B();
        a.test();
    }
}
