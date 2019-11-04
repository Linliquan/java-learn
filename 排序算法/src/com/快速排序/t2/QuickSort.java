package com.快速排序.t2;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int [] arr, int left,int right){

        if(left < right){
            int p = 0;
            p = partition(arr,left,right);
            quickSort(arr,left,p-1);
            quickSort(arr,p+1,right);
        }
    }

    public static int partition(int [] arr,int left, int right){
       int key = arr[left];

       while(left < right){
           while (left < right && arr[right] >= key ){
               right--;
           }
           arr[left] = arr[right];

           while (left <right && arr[left] <= key ){
               left++;
           }
           arr[right] = arr[left];
       }
       arr[left] = key;
       return left;
    }



    public static void main(String[] args) {
        int arr[] = {65, 58, 95, 10, 57, 62, 13, 106, 78, 23, 85};
        System.out.println("未排序："+Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后："+Arrays.toString(arr));
    }


}