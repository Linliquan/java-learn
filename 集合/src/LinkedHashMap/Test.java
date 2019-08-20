package LinkedHashMap;

import java.util.LinkedHashMap;

public class Test {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(2,"ff");
        linkedHashMap.put(2,"hh");
        linkedHashMap.put(2,"ff");
        linkedHashMap.put(6,"aa");
        linkedHashMap.put(3,"kh");
        linkedHashMap.put(9,"de");

        for (Integer key : linkedHashMap.keySet()){
            System.out.println(key +" "+ linkedHashMap.get(key));
        }

        for(String v : linkedHashMap.values()){
            System.out.println(v);
        }
    }
}
