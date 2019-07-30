package com.冒泡排序;

public class Dubble {

    //冒泡排序
    public static int [] bubbleSort(int [] array){
        if (array.length == 0){
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
      int [] a = {2,5,1,8,4,9,2};
      bubbleSort(a);
      for(int i: a){
          System.out.print(i+" ");
      }
    }
}
