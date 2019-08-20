package com.匿名内部类;

public class Test {
    public static void main(String[] args) {
         Test test = new Test();
         test.f1.show();
         String a = "235";
         a.substring(1,2);
        String[] strArray={"1","2","3"};
        String [] c = new String[8];

    }
    F f1 = new F(){
        @Override
        public void show(){
            System.out.println("hello");
        }

    };



    class F{
        public void show(){
            System.out.println("哈哈");
        }
    }
}
