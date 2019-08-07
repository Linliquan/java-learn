package TreeSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        //构建TreeSet
        Set<Integer> s1 = new TreeSet();
        s1.add(10);
        s1.add(30);
        s1.add(20);

        System.out.println(s1);

        //自定义规则的TreeSet
        //客户端排序：自己写一个比较器，转给TreeSet
        /**
         * 比较规则
         * 当TreeSet集合添加数据的时候就会触发比较器的compare()方法
         */
        Comparator<Integer> comp = new Comparator<Integer>() {
            /**
             * o1 当前添加的数据
             * o2 集合中已经存在的数据
             * 返回0： 表示 o1 == o2
             * -1 ： o1 < o2
             * 1 : o1 > o2
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1+"--"+o2);
                return -1;
            }
        };

        Set<Integer> s2 = new TreeSet<>(comp);
        s2.add(33);
        s2.add(10);
        s2.add(53);

        System.out.println(s2);

    }
}
