package eaxm.t4;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Test {
    public static void main(String[] args) {
        String str1 = new String("gg");
        System.out.println("1"+1+1);
        System.out.println(1+1+"1");
        System.out.println(str1==str1.intern());

        Integer a = 111;
        Integer b = 111;
        Integer c = new Integer(111);
        Integer d = new Integer(111);
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(c.equals(d));
    }
}
