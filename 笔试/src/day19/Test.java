//import java.util.Scanner;
//
//public class Main {
//
//    static int f(int n){
//        int k = 0;
//        ++k;
//        int s2 = 1;
//        long  t = 1;
//        while(2*s2 <= n){
//            int b = n -s2;
//            t*=s2;
//            long  sum = 1;
//            for(int i = 0; i < s2; i++){
//                sum*=(b-i);
//                k+=sum/t;
//                ++s2;
//            }
//
//        }
//        return k;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        f(n);
//    }
//}