package singleton;

//饿汉式
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(Singleton instance){
        return instance;
    }
}
