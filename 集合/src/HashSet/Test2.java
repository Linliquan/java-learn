package HashSet;

import java.util.HashSet;
import java.util.Set;

//
public class Test2 {


    public static void main(String[] args) {
        Set hashSet = new HashSet();
        hashSet.add(3);
        hashSet.add(8);
        hashSet.add(8);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(5);
        hashSet.add(5);


        System.out.println(hashSet);

    }
}
