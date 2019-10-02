/*

package springAOP.CGLIBDynamicProxy;

import net.sf.cglib.proxy.Enhancer;

//需要配置xml文件导入jar包才能实现
public class Test {
    public static void main(String[] args) {
        ChineseProxy chineseProxy = new ChineseProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Chinese.class);
        enhancer.setCallback(chineseProxy);

        Chinese proxy = (Chinese) enhancer.create();
        proxy.sayHello();
    }
}

*/