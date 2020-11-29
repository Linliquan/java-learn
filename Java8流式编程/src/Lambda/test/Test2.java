package Lambda.test;

/**
 * @author linliquan
 * @description:
 * @create 2020/11/16 20:47
 */

import Lambda.interfaces.NoReturnMultiParam;
import Lambda.interfaces.NoReturnOneParam;
import Lambda.interfaces.ReturnMultiParam;
import Lambda.interfaces.ReturnOneParam;

/**
  lambda简化版 - lambda基础语法
 */
public class Test2 {
    public static void main(String[] args) {
        //1.简化参数类型，可以不写参数类型，但是必须所有参数都不写
        NoReturnMultiParam lamdba1 = (a, b) -> {
            System.out.println("简化参数类型");
            System.out.println("简化参数类型");
        };
        lamdba1.method(1, 2);

        // 2.省略参数小括号，如果只有一个参数，则可以简化参数括号
        NoReturnOneParam lambda2 = a -> {
            System.out.println("如果只有一个入参，可以简化参数 a = " + a);
        };
        lambda2.method(9);

        // 3. 如果方法体只有一条语句，则可以省略花括号
        NoReturnOneParam lambda3 = b -> System.out.println("b = " + (b + 6));
        lambda3.method(6);

        //4.如果方法体只有一条语句，并且是 return 语句，则可以省略方法体大括号
        ReturnOneParam lambda4 = a -> a + 3;
        System.out.println(lambda4.method(5));

        //5.如果方法体只有一条语句，并且是 return 语句，则可以省略方法体大括号
        ReturnMultiParam lambda5 = (a , b) -> a + b - 1;
        System.out.println(lambda5.method(6, 10));
    }
}
