package test;

import java.util.*;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-03-07 15:25
 **/
public class Test {

    public static String getRandom() {
        String num = "";
        for (int i = 0; i < 6; i++) {
            num = num + String.valueOf((int) Math.floor(Math.random() * 10));
        }
        return num;
    }

    public static void main(String[] args) {

        Date date3 = new Date();
        Integer a = 1;
        String b = "0";

        if (1 != 2){
            System.out.println("阿斯蒂芬");
            System.out.println("feature 1017");
        }else {
            System.out.println("feature 1017");
            System.out.println("哈哈 github github");
        }

        List<Integer> staffIds = new ArrayList<>();
        staffIds.add(234);
        staffIds.add(1);
        staffIds.add(34);
        staffIds.add(67);
        staffIds.add(3);
        staffIds.add(99);

        Random random = new Random();
        int n = random.nextInt(staffIds.size());
        System.out.println( staffIds.get(n));

        long hostitalIntervalTime = (100000 / (1000 * 60));
        System.out.println((int)hostitalIntervalTime);

         Map<String,String> hashMap = new HashMap<>();
         hashMap.put("a",null);
         hashMap.put("b",null);
         hashMap.put("",null);
         hashMap.put(null,null);

        System.out.println("哈哈");
        System.out.println("this is feature_1017");
        for (String key: hashMap.keySet()) {
            System.out.println(key + " "+ hashMap.get(key));
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        if (list.contains(5)){
            System.out.println("哈哈哈哈HHH");
        }
        System.out.println(Test.getRandom());
        for (int i = 0; i< 20;i++){
            System.out.print( (int)(Math.random()*10) +" ");
        }






    }
}
