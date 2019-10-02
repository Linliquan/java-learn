package springAOP.JDKDynamicProxy;

public class ChinesePeople implements People {
    @Override
    public void sayHello() {
        System.out.println("ChinesePeople Say Hello");
    }
}
