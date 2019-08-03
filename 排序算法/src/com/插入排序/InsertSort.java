package com.插入排序;

import java.util.Arrays;

public class InsertSort {

    //插入排序
    /**
     * 1.首先需要明确待排序的数列由两部分组成，一部分是已排好序的部分，另一部分是待排序的部分；
     * 2.接着我们每次选择待排序的部分的第 1 个元素，分别与前面的元素进行比较。当大于前面的元素时，
     *   可以直接进入已排好序的部分；当小于前面的元素时，需要把这个元素拿出来，将前面的元素后移一位，
     *   继续与前面的元素相比，直到比较完数组的第 1 个元素或者出现一个元素小于我们拿出来的这个元素，
     *   这时停止比较、移动，直接把这个元素放到当时的空位上；
     * 3.一直重复步骤 2，当待排序的部分已经没有元素可进行插入时，停止操作，当前的数列为已排好序的数列。
     */
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
