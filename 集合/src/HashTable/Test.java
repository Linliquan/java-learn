package HashTable;

import java.util.Hashtable;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(3,"fdg");
        hashtable.put(3,"fdg");
        hashtable.put(6,"jj");
        hashtable.put(2,"kk");

        for (Map.Entry<Integer,String> entry: hashtable.entrySet()){
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }

    }
}
