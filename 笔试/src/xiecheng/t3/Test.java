package xiecheng.t3;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m,int[] array) {

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length/3; j++) {
                sum = sum + array[j];
                if(sum > max){
                    max = sum;
                }
            }
            for (int j = array.length/3; j < array.length/2; j++) {
                sum = sum + array[j];
                if(sum > max){
                    max = sum;
                }
            }
            for (int j = array.length/2; j < array.length; j++) {
                sum = sum + array[j];
                if(sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}
