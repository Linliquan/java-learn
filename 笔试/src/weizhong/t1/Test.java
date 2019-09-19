package weizhong.t1;

import java.util.Scanner;

public class Test {

    public static long  f(int n){
        if(n==0){
            return 1;
        }else if(n==1){
            return 1;
        }else{
            return n*f(n-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a = f(n);

        String str = Long.toString(a);

        for (int i = str.length(); i >= 0; i--) {
            char c = str.charAt(i-1);
            if(c!='0'){
                System.out.println((char) c);
                break;
            }
        }

    }
}
