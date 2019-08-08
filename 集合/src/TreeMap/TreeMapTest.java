package TreeMap;


import HashMap.Test;

import java.util.TreeMap;

public class TreeMapTest {

    public <T,D> T show(T t){

        return t;
    }

    public static void main(String[] args) {


//        Comparator com = new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//        };

        TreeMap treeMap = new TreeMap();

        treeMap.put("a",5);
        treeMap.put("h",3);
        treeMap.put("ac",2);
        treeMap.put("ab",7);

        System.out.println(treeMap);




    }
}
