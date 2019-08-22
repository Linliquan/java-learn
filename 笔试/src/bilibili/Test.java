package bilibili;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuffer sb = new StringBuffer();
        String [] s = str.trim().split(" ");
        for (int i = s.length -1; i >= 0 ; i--) {
            if(s[i]!=""){
                sb.append(s[i]);
            }
            if(i-1>=0){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
