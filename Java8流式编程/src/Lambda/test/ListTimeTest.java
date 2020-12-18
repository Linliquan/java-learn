package Lambda.test;

import java.util.ArrayList;
import java.util.List;


/**
 * @author linliquan
 * @description: for遍历执行时间对比
 * @create 2020/12/18 10:01
 */
public class ListTimeTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        // for循环
        long timeMillis1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        long endTimeMillis1 = System.currentTimeMillis();
        System.out.println();
        System.out.println("for循环执行时间："+(endTimeMillis1 - timeMillis1) + "ms");

        // for增强
        long timeMillis2 = System.currentTimeMillis();
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        long endTimeMillis2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("for增强执行时间："+(endTimeMillis2 - timeMillis2) + "ms");


        // forEach遍历
        long timeMillis3 = System.currentTimeMillis();
        list.forEach(e -> {
            System.out.print(e + " ");
        });
        long endTimeMillis3 = System.currentTimeMillis();
        System.out.println();
        System.out.println("forEach遍历执行时间："+(endTimeMillis3 - timeMillis3) + "ms");

        // 执行结果，数据量在1000 - 1000000之间内，执行时间：for增强 < for循环 < forEach遍历

    }


}
