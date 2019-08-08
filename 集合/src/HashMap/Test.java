package HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(10,"tom");
        hashMap.put("10","lisi5");
        hashMap.put(10,"lisi");
        hashMap.put(2,null);
        hashMap.put(3,null);
        hashMap.put(null,null);
        hashMap.put(null,null);
        hashMap.remove(10);

        System.out.println(hashMap);

        System.out.println( hashMap.get("10"));

        //遍历map
        Set keySet = hashMap.keySet();
        System.out.println(keySet);
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //map中

        System.out.println(hashMap);
    }
}
