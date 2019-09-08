package mihayou.t1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char c = ' ';

        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j) || s.charAt(i) == s.charAt(j) + 32 || s.charAt(i) == s.charAt(j) - 32){
                    count++;
                }
            }
            if( max < count){
                max = count;
                c = s.charAt(i);
            }
            count = 0;

        }
        System.out.println((char) c+(max+1));
    }
}
