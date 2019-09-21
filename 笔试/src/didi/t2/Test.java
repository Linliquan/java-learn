package didi.t2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     ///   int n = sc.nextInt();
        String str = sc.nextLine();
         String [] s = str.split("-\\|+");
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]+" ");
        }
    }
}
