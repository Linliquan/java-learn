package jd.t1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < a.length -1; i++) {

            if(i != a.length-1){
                if(a[i] < a[i+1]){
                    count++;
                }
            }else {
                if(a[i] < a[i+1]){
                    count--;
                }
            }

        }
        System.out.println(count+1);
    }
}
