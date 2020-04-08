package singleton;

//双重效验锁
public class Singleton2 {
    private volatile static Singleton instance;
    private Singleton2(){}

    public static synchronized Singleton2 getInstance(Singleton2 instance){
        if(instance == null){
                synchronized (Singleton2.class){
                    if (instance == null){
                        instance = new Singleton2();
                    }
                }
        }
        return instance;
    }
}
