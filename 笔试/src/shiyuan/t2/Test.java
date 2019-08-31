package shiyuan.t2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] a = new int [n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        int k = 0;
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length-1-i; j++) {
                if(a[j] > a[j+1]){

                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                   k++;

                }

            }
        }
        System.out.println(k);

    }
}
