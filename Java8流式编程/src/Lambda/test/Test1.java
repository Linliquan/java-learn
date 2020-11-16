package Lambda.test;

import Lambda.interfaces.*;

/**
 * @author linliquan
 * @description:
 * @create 2020/11/16 20:14
 */
public class Test1 {
    public static void main(String[] args) {

        // 1.无参数无返回
        NoReturnNoParam noReturnNoParam = () -> {
            System.out.println("无参数无返回");
        };
        noReturnNoParam.method();

        // 2.一个参数无返回
        NoReturnOneParam noReturnOneParam = (a) -> {
            System.out.println("一个参数无返回 a =" + a*2);
        };
        noReturnOneParam.method(6);

        // 3.多个参数无返回
        NoReturnMultiParam noReturnMultiParam = (a, b) -> {
            System.out.println("多个参数无返回值 " + (a + b));
        };
        noReturnMultiParam.method(3,4);

        // 4.无参数有返回值
        ReturnNoParam returnNoParam = () -> {
            System.out.println("无参数有返回值");
            return 5;
        };
        int b = returnNoParam.method();
        System.out.println("b = "+b);

        // 5.一个参数有返回值
        ReturnOneParam returnOneParam = (a) -> {
            System.out.println("一个参数有返回值");
            return a + 5;
        };
        int a = returnOneParam.method(6);
        System.out.println("a = " + a);

        // 6.多个参数有返回值
        ReturnMultiParam returnMultiParam = (c, d) -> {
            System.out.println("c - d = " + (c - d));
            return c - d;
        };
        int result = returnMultiParam.method(8, 2);
        System.out.println("result = " + result);


    }

}
