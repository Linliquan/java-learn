package com.选择排序;

public class Select {



    //选择排序:先把最小的元素放到最前面，再从剩下的元素中寻找最小的元素放在排序好的元素后面，以次类推。
    public static int [] SelectSort(int [] array){
        if (array.length == 0){
            return array;
        }
        for (int i = 0; i < array.length ; i++) {
            int mixIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[mixIndex]){
                    mixIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[mixIndex];
            array[mixIndex] = temp;

        }
        return array;
    }

    public static void main(String[] args) {
        int [] a = {2,5,1,8,4,9,2,7};
        SelectSort(a);

        for(int i: a){
            System.out.print(i+" ");
        }
    }


}
