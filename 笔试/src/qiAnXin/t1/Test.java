package qiAnXin.t1;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //        int [] a = new int[str1.length];
        //        int [] b = new int[str2.length];

        String [] str1 = sc.nextLine().split(" ");
        String [] str2 = sc.nextLine().split(" ");
        int m = sc.nextInt();
        int sum = 0;
        int b = -1;
        for (int i = 0; i < str2.length; i++) {

            int a = Integer.parseInt(str2[i]);

            if(a == m){
                sum++;
                for (int j = i; j < str2.length; j++) {
                    b = Integer.parseInt(str1[j]);
                    sum++;
                    m = b;
                }
            }

        }

        System.out.println(sum);


    }
}
