package ConcurrentHashMap;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(1,"fdj");
        concurrentHashMap.put(1,"fdj");
        concurrentHashMap.put(1,"fdghd");
        concurrentHashMap.put(2,"jh");
        concurrentHashMap.put(3,"哈哈");

        for (Integer key : concurrentHashMap.keySet()){
            System.out.println(key+" "+concurrentHashMap.get(key));
        }

        //法一
        for(Integer key : concurrentHashMap.keySet()){
            System.out.println("输出键值对："+key+" "+concurrentHashMap.get(key));
        }

        //法二：
        for(Map.Entry<Integer,String> entry: concurrentHashMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }


    }
}
