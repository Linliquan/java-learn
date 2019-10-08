package 统计各个字母出现的次数;

import java.util.LinkedHashMap;

public class Test {



    public static void countWord(String str){
        LinkedHashMap<Character,Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(linkedHashMap.containsKey(str.charAt(i))){
                int t = linkedHashMap.get(str.charAt(i));
                linkedHashMap.put(str.charAt(i),++t);
            }else {
                linkedHashMap.put(str.charAt(i),1);
            }
        }
        for(char c : linkedHashMap.keySet()){
            System.out.println("字母："+ c +" 出现的次数："+linkedHashMap.get(c));
        }

    }

    public static void main(String[] args) {
        String str = "sdhfdsjkdstsss dfg hfd";
        countWord(str);
    }
}
