package com.选择排序;

//选择排序
public class Test {
    public static void main(String[] args) {
        int [] a = {2,6,2,7,1,4,9,3};

        for (int i = 0; i < a.length; i++) {
            int mix = i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j] < a[mix]){
                    mix = j;
                }
            }
            int t = a[i];
            a[i] = a[mix];
            a[mix] = t;
        }

        for(int i : a){
            System.out.print(i+" ");
        }
    }
}
