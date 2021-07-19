package test2;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: linliquan
 * @create: 2020-09-20 15:54
 **/
public class Test2 {

    int a = 1;

    private static void m(){
        System.out.println("呵呵");
    }

    public static void main(String[] args) {
        Test2 test = new Test2();
        System.out.println(test.a);

        System.out.println("哈哈哈");

        Map<String, String> hashmap = new HashMap<>();
        hashmap.put("aa","vvv");
        String bb = hashmap.get("bb");
        System.out.println(bb);

        Calendar calendar = Calendar.getInstance();
        System.out.println("Current Date = " + calendar.getTime());
        //将小时数 -1
        calendar.add(Calendar.HOUR_OF_DAY, -1);
        System.out.println("Updated Date = " + calendar.getTime());
    }
}
