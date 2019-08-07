public class A {

    static {
        printStr("父类的静态块");
    }

    public static String a = printStr("父类的静态变量");

    public String s = printStr("父类的非静态变量");



    {
        printStr("父类的非静态块");
    }

    public A(){
        printStr("父类构造方法");
    }

    public static String printStr(String str){
        System.out.println(str);
        return str;
    }
}
