package TreeSet;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet1 {
    public static void main(String[] args) {
 //       TreeSet treeSet = new TreeSet();

        TreeSet treeSet = new TreeSet(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if((o1.length()-o2.length()!=0)){
                    return o1.length()-o2.length();
                }
                return o2.compareTo(o1);
            }
        });

        treeSet.add("HashSet");
        treeSet.add("ArrayList");
        treeSet.add("TreeMap");
        treeSet.add("HashMap");
        treeSet.add("TreeSet");
        treeSet.add("LinkedList");

        Iterator iterator = treeSet.iterator();

        System.out.println(treeSet);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
