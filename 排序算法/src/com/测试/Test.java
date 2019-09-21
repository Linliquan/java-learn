package com.测试;

public class Test {
    public static void main(String[] args) {
        int [] a = {3,1,6,8,7,4,5};

//        //冒泡排序
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a.length-1-i; j++) {
//                if(a[j] > a[j+1]){
//                    int t = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = t;
//                }
//            }
//        }


//        //选择排序
//        for (int i = 0; i < a.length; i++) {
//
//            int mix = i;
//
//            for (int j = i+1; j < a.length; j++) {
//              if(a[j] < a[mix]){
//                  mix = j;
//              }
//            }
//            int t = a[i];
//            a[i] = a[mix];
//            a[mix] = t;
//
//        }

//        //插入排序
//        for (int i = 1; i < a.length; i++) {
//
//            int j = i;
//            int temp = a[i];
//
//            for (; j > 0 && a[j-1] > temp; j--) {
//                    a[j] = a[j-1];
//            }
//            a[j] = temp;
//        }

        for(int i : a){
            System.out.print(i+ " ");
        }

    }
}
