package didi.t1;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] a = new int[n];
        String [] str = new String[n-1];

        for (int i = 0; i < 2*n+1; i++) {
             if (i%2 == 0){
                 int j = 0;
                 a[j] = sc.nextInt();
                 j++;
             }else {
                 int j = 0;
             //    str[j] = sc.next();
                 j++;
             }

        }

    }
}
