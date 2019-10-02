/*
//需要配置xml文件导入jar包才能实现
package springAOP.CGLIBDynamicProxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ChineseProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] args,MethodProxy methodProxy) throws Throwable {
        Object intercept = methodProxy.invokeSuper(object, args);
　　　　 System.out.println("-------- end ---------");
　　　　return intercept;
　　}
}

*/
