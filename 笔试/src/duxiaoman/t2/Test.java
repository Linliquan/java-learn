package duxiaoman.t2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < a.length; i++) {

            int t = a[i];
            for (int j = 1; j < a[i]; j++) {
                for (int k = j+1; k <= a[i]; k++) {

                }
            }
            
        }




    }
}
