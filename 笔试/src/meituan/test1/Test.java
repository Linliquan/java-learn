package meituan.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Test {

//    public static List<Integer> partitionLabels(String S) {
//        // get the last seen index for each letter 'a' - 'z'
//
//    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

     //   partitionLabels(str);

        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i){
            last[S.charAt(i) - 'a'] = i;
        }


        int boundary = 0, cnt = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            // update boundary and cnt along the way
            char curChar = S.charAt(i);
            boundary = Math.max(boundary, last[curChar - 'a']);
            cnt++;
            // if we reach the boundary, we collect result and reset count to 0
            if (i == boundary) {
                ans.add(cnt);
                cnt = 0;
            }
        }
        System.out.println(ans);

    }
}
