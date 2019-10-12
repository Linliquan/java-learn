package com.二分查找;

//二分查找：用于有序的序列
public class Test {
    public static int find(int [] a,int left,  int right,int key){
            if(key < a[left] || key > a[right] || left > right){
                return -1;
            }
            while (left <= right){
                int mid = (left + right)/2;
                if(key < a[mid]){
                    right = mid -1;
                }else if(key > a[mid]){
                    left = mid +1;
                }else {
                    return mid;
                }
            }
            return -1;
    }

    public static void main(String[] args) {
        int [] a = {2,4,5,8,9,12,45};
        int b =find(a,0,a.length-1,9);
        if (b == -1){
            System.out.println("没有找到");
        }else {
            System.out.println("找到的下标为"+b);
        }
    }
}
