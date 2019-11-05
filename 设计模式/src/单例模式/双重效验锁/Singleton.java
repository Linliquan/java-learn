package 单例模式.双重效验锁;

//懒汉式的双重效验锁
public class Singleton {
    private volatile static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
