package xiecheng2.t1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static boolean CheckBlackList(String userIP, String blackIP) {
        String uIP = userIP;
        String bIP = blackIP;

        String [] u = uIP.split(".");

        if(uIP.length() >= bIP.length() && bIP.length() <= uIP.length()+3){
            return true;
        }
        if(uIP.length() == bIP.length() && !uIP.equals(bIP)){
            return false;
        }

        if(uIP.length() < bIP.length()){
            String [] s = bIP.split(".");
            String s4 = s[3];
            String [] s2 = s4.split("\\/");
            String s5 = s2[1];
            int k = 0;
            int t5 = Integer.parseInt(s5);
            for (int i = 0; i < 3; i++) {
                if(u[i].equals(s[i])){
                    k++;
                }
            }
            if(k == 3){
                return true;
            }

        }

        return false;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;

        String _userIP;
        try {
            _userIP = in.nextLine();
        } catch (Exception e) {
            _userIP = null;
        }

        String _blackIP;
        try {
            _blackIP = in.nextLine();
        } catch (Exception e) {
            _blackIP = null;
        }

        res = CheckBlackList(_userIP, _blackIP);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
