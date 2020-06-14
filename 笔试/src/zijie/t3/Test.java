package zijie.t3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int n =4;
        int [][] a = new int[4][4];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }
}