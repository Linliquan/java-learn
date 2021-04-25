package Lambda.test;

/**
 * @author linliquan
 * @description:
 * @create 2020/11/17 10:19
 */

import Lambda.interfaces.ReturnNoParam;
import Lambda.interfaces.ReturnOneParam;

import java.math.BigDecimal;

/**
 * lambda 表达式引用方法
 */
public class Exe1 {

    public static String bigDecimal2String(BigDecimal b) {
        if (b == null || BigDecimal.ZERO.compareTo(b) == 0) {
            return "0";
        } else {
            return b.stripTrailingZeros().toPlainString();
        }
    }

    /**
     * 引用方法：
     * 语法 方法归属者::方法名 静态方法的归属者为类名，普通方法归属者为对象
     */
    public static void main(String[] args) {

        ReturnOneParam returnOneParam = a -> doubleNum(a);
        System.out.println(returnOneParam.method(4));

        // lambda2 引用了已经实现的 doubleNum 方法
        ReturnOneParam lambda2 = Exe1::doubleNum;
        System.out.println(lambda2.method(3));

        // 普通方法为对象调用，静态方法为类名调用
        Exe1 exe1 = new Exe1();
        ReturnOneParam lambda3 = exe1::addTwo;
        System.out.println(lambda3.method(2));
        System.out.println(lambda3.method(2));

        String a = "123456";
        System.out.println("长度："+a.length());

        BigDecimal b1 = new BigDecimal("4.45964");
        BigDecimal b2 = new BigDecimal("4.41564");
        System.out.println(b1.subtract(b2));

        String s = Exe1.bigDecimal2String(b1);
        System.out.println(s);


    }

    /**
     * 要求:
     * 1. 参数数量和类型要与接口中定义的一致
     * 2.返回值类型要与接口中定义的一致
     *
     */
    public static int doubleNum(int a){
        return a*2;
    }
    public int addTwo(int a) {
        return a + 2;
    }
}
