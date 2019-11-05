package 单例模式.双重效验锁;

public class Test {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        String str = "ksdgjksd";

        StringBuffer sb = new StringBuffer(str);
        String s =  new String(sb);
        System.out.println(s);


    }
}
