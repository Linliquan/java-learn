package zijie.t1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] a = new int[n][n];
        if(n >= 1 && n <= 200){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    a[i][j] = sc.nextInt();
                }
            }
            int s = 0;

            for(int i = 0; i < n; i++){
                for(int j = i; j < n -1; j++){
                    if(a[i][j] >= 3){
                        if(a[i][j] >= 3 ){
                            s++;
                        }
                        if(a[i+1][j+1] >= 3){
                            s--;
                        }
                    }
                }
            }
            int count = s;
            System.out.println(count+1);

        }
    }
}
