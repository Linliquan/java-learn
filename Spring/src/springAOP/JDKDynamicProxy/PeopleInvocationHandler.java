package springAOP.JDKDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PeopleInvocationHandler implements InvocationHandler {
    private Object people;

    PeopleInvocationHandler(People people){
        this.people = people;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置通知");
        Object invoke = method.invoke(people,args);
        System.out.println("后置通知");
        return invoke;
    }
}
