package HashSet;



import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


//
public class Test2 {


    public static void main(String[] args) {
        Collection hashSet = new HashSet();

        hashSet.add(8);
        hashSet.add(8);
        hashSet.add(2);
        hashSet.add(5);
        hashSet.add(5);

//        Iterator iterator = hashSet.iterator();
//
//        System.out.println(hashSet);

        //法一
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println( iterator.next());
        }
        




    }
}
