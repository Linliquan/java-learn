package bilibili3;

import java.util.Scanner;

public class Test {

    //W=M,N=N,
    public static int f(int W ,int N ,int [] weights,int [] values){
        int [][] dp = new int[N+1][W+1];
        for (int i = 0; i < N; i++) {
            int w = weights[i-1],v = values[i-1];
            for (int j = 1; j <= W; j++) {
                if (j>=w){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w]+v);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int [] w = new int [N];
        int [] v = new int [N];

        for (int i = 0; i < N; i++) {
            int h = sc.nextInt();
            w[i] = h;
        }
        for (int i = 0; i < N; i++) {
            int h = sc.nextInt();
            v[i] = h;
        }


        f(M,N,w,v);

    }
}
