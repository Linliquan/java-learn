package com.插入排序;

import java.util.Arrays;

public class InsertSort {

    //插入排序
    public static int [] insertSort(int [] array){
        if (array.length == 0){
            return array;
        }

        // 循环待排序的部分的数列
        // 第一个数据（下标为0的数据）由于插入排序刚开始，有序表中没有任何记录，可以直接添加到有序表中
        for (int i = 1; i < array.length ; i++) {
            int temp = array[i];
            int j = i;

            // 如果前面的元素大于temp，则向后移
            for ( ; j > 0 && array[j-1] > temp; j--) {
                    array[j] = array[j-1];
            }

            // 前一个元素（array[j - 1]）和后一个元素（array[j]）是相同的
            // 在下一轮时，当array[j - 1]小于或等于temp时，将temp插入array[j]（即上一轮的array[j - 1]）
            array[j] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int [] a = {3,1,5,7,2,4,9,6};
        insertSort(a);

        for(int i: a){
            System.out.print(i+" ");
        }
    }
}
