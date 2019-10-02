package springAOP.JDKDynamicProxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {

        People chinese = new ChinesePeople();
        PeopleInvocationHandler invocationHandler = new PeopleInvocationHandler(chinese);
        People proxy = (People) Proxy.newProxyInstance(chinese.getClass().getClassLoader(),chinese.getClass().getInterfaces(),invocationHandler);
        proxy.sayHello();

    }
}
