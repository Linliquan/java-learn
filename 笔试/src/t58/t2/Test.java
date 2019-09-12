package t58.t2;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int [] a = new int[list.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = 1;
        }

        for (int i = 0; i < list.size(); i=i+2) {
            if(list.get(i) > list.get(i+1)){
                a[i]++;
            }else {
                a[i+1]++;
            }
            if(i < list.size() -2){
                if(list.get(i+1) < list.get(i+2)){
                    a[i+2]++;
                }
            }

        }

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+ " ");
        }

        System.out.println(sum);
    }
}
