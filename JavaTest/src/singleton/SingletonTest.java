package singleton;

//懒汉式
public class SingletonTest {
    private  static SingletonTest instance;
    private SingletonTest(){}

    public static synchronized   SingletonTest getInstance(SingletonTest instance){
        if(instance == null){
            instance = new SingletonTest();
        }
        return instance;
    }


}
