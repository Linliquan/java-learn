package xiaomi.t2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static void solution(String[] input) {
        int [] a = new int[input.length];
        for (int i = 0; i < input.length; i++) {
                a[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < a.length; i++) {
            int index = (int)(a.length/(Math.sqrt(a.length)));

            for (int j =  0; j < index*(i+1) && index*(i+1) < a.length; j++) {
                if (a[j] == a[j+1]){
                    a[j] = a[j]+a[j+1];
                    a[j] = 0;
                }else {
                    a[j] = a[j+1];
                }
            }

        }
        for (int i = 0; i < a.length; i++) {
            if(a.length%4!=0){
                System.out.print(a[i]+" ");
            }else {
                System.out.println();
            }

        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        solution(_input);

    }
}

