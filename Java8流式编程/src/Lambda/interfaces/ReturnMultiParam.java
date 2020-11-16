package Lambda.interfaces;

/**
 * @author linliquan
 * @description:
 * @create 2020/11/16 20:12
 */


/**多个参数有返回值*/
@FunctionalInterface
public interface ReturnMultiParam {
    int method(int a, int b);
}