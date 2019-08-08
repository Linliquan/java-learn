package TreeSetOldAndEven;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 使用TreeSet和Comparator，写Test.java
 * 要求：对TreeSet中的元素
 * 	1，2，3，4，5，6，7，8，9，10进行排列，
 * 排序逻辑为奇数在前偶数在后，
 * 奇数按照升序排列，偶数按照降序排列
 * 输出结果：1 3 5 7 9 10 8 6 4 2
 */
public class Test {
    public static void main(String[] args) {
        Set<Integer> s = new TreeSet<>(new Comparator<Integer>() {
            //重写compare方法
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("o1="+o1+" o2="+o2);
                if(o2%2==0){
                    if (o1%2==0){
                            return o2 -o1;
                    }else{
                        return -1;
                    }
                }else {
                    if (o1%2==0){
                        return 1;
                    }else{
                        return o1 -o2;
                    }
                }


            }
        });

        s.add(2);
        s.add(6);
        s.add(4);
        s.add(1);
        s.add(3);
        s.add(5);
        s.add(8);
        s.add(10);
        s.add(9);
        s.add(7);

        Iterator iterator = s.iterator();

        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

    }
}
