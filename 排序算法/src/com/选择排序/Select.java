package com.选择排序;

public class Select {

    //选择排序
    public static int [] SelectSort(int [] array){
        if (array.length == 0){
            return array;
        }
        for (int i = 0; i < array.length ; i++) {
            int mixIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[i]){
                    mixIndex = j;
                }
                int temp = array[i];
                array[i] = array[mixIndex];
                array[mixIndex] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int [] a = {2,5,1,8,4,9,2};
        SelectSort(a);

        for(int i: a){
            System.out.print(i+" ");
        }
    }
}
