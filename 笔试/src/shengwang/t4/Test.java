package shengwang.t4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {

    public static int sum(String s){
        char [] c = s.toCharArray();
        boolean [] l = new boolean[26];
        for (int i = 0; i < 26; i++) {
            l[i] = false;
        }
            int r = 0;
            for (int j = 0; j < c.length; j++) {
                if (l[c[j]-'a'] == false){
                    l[c[j]- 'a'] = true;
                    r++;
                }
            }
        return r;
    }

    public static int bS(int [] num,int n){
        int l =0,r = num.length-1,mid = (l+r)/2;
        while (l < r){
            if(num[mid] < n){
                l = mid + 1;
            }else if(num[mid] > n){
                r = mid -1;
            }else {
                return mid;
            }
            mid = (l + r)/2;
        }
        return -1;
    }

    public static void test(String s){
        int [] f = {1,2,3,5,8,13,21,34,55,89};
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                String sub = s.substring(i,j);
                int num = sum(sub);
                if(bS(f,num) >= 0 && list.contains(sub)){
                    list.add(sub);
                }
            }
            Collections.sort(list);
            for (int j = 0; j < list.size(); j++) {
                System.out.println(list.get(i));
            }
        }

    }

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      while (sc.hasNext()){
          String s = sc.nextLine();
          test(s);
      }

    }
}