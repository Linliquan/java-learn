package wangwei.t1;//package wangwei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] w= bufferedReader.readLine().split(" ");
        String s= bufferedReader.readLine();
        int n = w.length;
        if(n == 0){
            System.out.println("输入错误");
            return;
        }
        int[] a=new int[n];
        for(int i=0;i<n;++i){
            a[i]=Integer.parseInt(w[i]);
        }
        int b=Integer.parseInt(s);
        //哈希表
        Map<Integer,Integer> map=new HashMap<>();
        int t=0;
        for(int i=0;i<n;++i){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        for(int i=0;i<n;++i){
            if(map.get(a[i])==0)
                continue;
            if(b>=a[i]){
                map.put(a[i],map.get(a[i])-1);
                int k=b-a[i];
                while(k>0&&(map.get(k)==null||map.get(k)==0)){
                    k--;
                }
                t++;
                if(k>0){
                    map.put(k,map.get(k)-1);
                }
            }
        }
        System.out.println(t);
    }
}

/**
 * 按行依次输入某城市到其他城市的传送时间，0表示当前城市，v1到其他城市的最短时间
 */

//
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Test {
//
//    public  int countLeastBoat(Integer []nums,int maxLoad){
//        Arrays.sort(nums);
//        int count = 0;
//        int i = 0;
//        int j = nums.length-1;;
//        while(i<j) {
//            if(nums[i]+nums[j] <= maxLoad) {
//                i++;
//                j--;
//            } else {
//                j--;
//            }
//            count++;
//        }
//        return count + (j==i?1:0);
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        ArrayList<Integer> list = new ArrayList();
//
//        while (sc.hasNext()){
//
//        }
//
//
//
//    }
//}
//
///**
// public  int countLeastBoat(Integer []nums,int maxLoad){
// Arrays.sort(nums);
// int count = 0;
// int i = 0;
// int j = nums.length-1;;
// while(i<j) {
// if(nums[i]+nums[j] <= maxLoad) {
// i++;
// j--;
// } else {
// j--;
// }
// count++;
// }
// return count + (j==i?1:0);
// }
// */