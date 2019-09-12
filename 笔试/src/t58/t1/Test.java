package t58.t1;

import java.util.Scanner;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String [] s = str.split(",");
        TreeSet<Integer> tree = new TreeSet<>();



        for (int i = 0; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                tree.add(a);
        }
        System.out.println(tree.size());

    }
}
