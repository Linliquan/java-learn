package LinkedHashSet;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;


public class Test {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(8);
        linkedHashSet.add(5);
        linkedHashSet.add(5);
        linkedHashSet.add(6);

//        Iterator iterator = linkedHashSet.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        for(Integer i : linkedHashSet){
            System.out.println(i);
        }
    }
}
