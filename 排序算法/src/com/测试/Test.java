package com.测试;

public class Test {
    public static void main(String[] args) {
        int a = 5;
        String str = "101";

        //int类型转String类型
        String s = String.valueOf(5);
        s.equals("4");
        System.out.println(s);

        //String类型转int类型
        int b  = Integer.parseInt(str);
        System.out.println(b);

    }
}
