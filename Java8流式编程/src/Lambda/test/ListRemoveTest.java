package Lambda.test;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author linliquan
 * @description: 删除集合中的某个元素、集合内元素的排序
 * @create 2020/12/18 11:26
 */
public class ListRemoveTest {
    public static void main(String[] args) {
        ArrayList<Item2> items = new ArrayList<>();
        items.add(new Item2(11, "小牙刷", 12.05 ));
        items.add(new Item2(5, "日本马桶盖", 999.05 ));
        items.add(new Item2(7, "格力空调", 888.88 ));
        items.add(new Item2(17, "肥皂", 2.00 ));
        items.add(new Item2(9, "冰箱", 4200.00 ));

        items.forEach(System.out::println);

        // 删除集合中的某个元素
        items.removeIf(item2 -> item2.getId() == 7);

        System.out.println();
        //通过 foreach 遍历，查看是否已经删除
        items.forEach(System.out::println);

        ArrayList<Item2> list2 = new ArrayList<>();
        list2.add(new Item2(13, "背心", 7.80));
        list2.add(new Item2(11, "半袖", 37.80));
        list2.add(new Item2(14, "风衣", 139.80));
        list2.add(new Item2(12, "秋裤", 55.33));

        /*
        list.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getId()  - o2.getId();
            }
        });
        */

        list2.sort(((o1, o2) -> o1.getId() - o2.getId()));
        System.out.println(list2);

        // Lambda 表达式中的闭包问题
        int num = 10;

        Consumer<String> consumer = ele -> {
            System.out.println(num);
        };

//        num = num + 2;
        consumer.accept("hello");



    }


}
