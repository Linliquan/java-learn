package TreeSet;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet3 {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               return 0;
            }
        });

        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(5);
        treeSet.add(9);
        treeSet.add(3);
        treeSet.add(10);
        treeSet.add(7);
        treeSet.add(6);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }
}
