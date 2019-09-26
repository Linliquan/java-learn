package xiecheng.t2;

/**
 *
 *  public static String reverse1(String str) {
 *     return new StringBuilder(str).reverse().toString();
 *   }
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        String [] str = expr.split("\\(|\\)");
        String s = "";
        for (int i = 0; i < str.length; i++) {
            s = s +str[i];
        }
        return new StringBuilder(s).reverse().toString();

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
