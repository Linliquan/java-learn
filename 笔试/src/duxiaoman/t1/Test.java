package duxiaoman.t1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] a = new int[row][col];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                 a[i-1][j-1] = (i*j)%10;
            }
        }
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum = sum + a[i][j];
            }
        }
        System.out.println(sum+n+1);
    }
}
