package t1;

//权限测试

/**
 * 1.public : 谁都可以访问
 * 2.private：只有当前类可以访问
 * 3.default: 同一个包中才可以访问，即使是不同包中的子类也不可以。
 * 4.protected：同一个包中可以访问，子类可以访问
 */
public class A {

 // public int age = 10;
public int age = 10;

protected void f(){
    System.out.println("哈哈哈");
}

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.age);
    }
}
