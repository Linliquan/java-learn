package Lambda.test;

import Lambda.interfaces.NoReturnMultiParam;
import Lambda.interfaces.NoReturnNoParam;
import Lambda.interfaces.NoReturnOneParam;

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
        NoReturnOneParam noReturnOneParam = (int a) -> {
            System.out.println("一个参数无返回 a =" + a*2);
        };
        noReturnOneParam.method(6);

        // 3.多个参数无返回
        NoReturnMultiParam noReturnMultiParam = (int a,int b) -> {
            System.out.println("多个参数无返回值 " + (a + b));
        };
        noReturnMultiParam.method(3,4);





    }

}
