package shengwang.t1;

import java.util.Scanner;

public class Test {
    private static int [] f;
    private static int  n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            n = sc.nextInt();
            if (n == 0){
                break;
            }
            int m = sc.nextInt();
            f = new int[n+1];
            for (int i = 1; i <= n ; i++) {
                f[i] = i;
            }
            for (int i = 0; i < m; i++) {
                int a1 = sc.nextInt();
                int b1 = sc.nextInt();
                f(a1,b1);
            }
            if(n < 2){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    public static void f(int a,int b){
        int a2 = find(a);
        int b2 = find(a);
        if(a2!=b2){
            f[a2] = b2;
            n--;
        }
    }
    public static int find(int a){
        while (f[a]!= a){
            a = f[a];
        }
        return a;
    }
}