package 单例模式.懒汉式;

public class SingletonTest {
    public static void main(String[] args) {
       Singleton s1 = Singleton.getInstance();
       Singleton s2 = Singleton.getInstance();
       Singleton s3 = Singleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
