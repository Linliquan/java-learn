package 单例模式.饿汉式;

//法一：饿汉式
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }

}
