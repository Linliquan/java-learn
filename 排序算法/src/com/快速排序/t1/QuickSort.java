package com.快速排序.t1;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int [] arr,int left,int right){
        int pivot = 0;
        if(left < right){
            pivot = partition(arr,left,right);
            quickSort(arr,left,pivot-1);
            quickSort(arr,pivot+1,right);
        }
    }

    public static int partition(int [] arr,int left,int rigth){
        int key = arr[left];
        while (left < rigth){
            while (left < rigth && arr[rigth] >= key){
                rigth--;
            }
            arr[left] = arr[rigth];
            while (left < rigth && arr[left] <= key){
                left++;
            }
            arr[rigth] = arr[left];
        }
         arr[left]= key;
        return left;

    }


    public static void main(String[] args) {
        int arr[] = {65, 58, 95, 10, 57, 62, 13, 106, 78, 23, 85};
        System.out.println("未排序："+Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后："+Arrays.toString(arr));

    }
}
