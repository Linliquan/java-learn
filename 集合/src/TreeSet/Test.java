package TreeSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {

        /**
         * 自定义规则的TreeSet
         * 客户端排序：自己写一个比较器，转给TreeSet
         *
         * 比较规则
         * 当TreeSet集合添加数据的时候就会触发比较器的compare()方法
         */
        Comparator<Integer> comp = new Comparator<Integer>() {
            /**
             * o1 当前添加的数据
             * o2 集合中已经存在的数据
             * 0： 表示 o1 == o2
             * -1 ： o1 < o2
             * 1 : o1 > o2
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1+"--"+o2);
                return o2 -o1; //输出53 33 10，降序排序
              //  return  0;  //只输出一个元素：33
              //   return -1; //输出53 10 33，倒序输出
              //  return 1;  //输出33 10 55
            }
        };

        Set<Integer> s2 = new TreeSet<>(comp);
        s2.add(33);
        s2.add(10);
        s2.add(55);

        System.out.println(s2); //输入53 33 10，降序排序

    }
}
