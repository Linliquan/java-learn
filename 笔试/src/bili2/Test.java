package bili2;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.trim().split(",");

        int[] a = new int[s.length];

        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        printMin(a);
    }

    private static void printMin(int[] array) {
        int[] clone = array.clone();
        printMin(clone, 0, clone.length - 1);
        for (int i : clone)
            System.out.print(i);
    }

    private static void printMin(int[] array, int start, int end) {

        if (start < end) {
            int main_number = array[end];
            int small_cur = start;
            for (int j = start; j < end; j++) {
                if (isSmall(String.valueOf(array[j]), String.valueOf(main_number))) {
                    int temp = array[j];
                    array[j] = array[small_cur];
                    array[small_cur] = temp;
                    small_cur++;
                }
            }
            array[end] = array[small_cur];
            array[small_cur] = main_number;
            printMin(array, 0, small_cur - 1);
            printMin(array, small_cur + 1, end);
        }

    }

    public static boolean isSmall(String m, String n) {
        String left = m + n;
        String right = n + m;
        boolean result = false;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) < right.charAt(i))
                return true;
            else if (left.charAt(i) > right.charAt(i))
                return false;
        }

        return result;
    }


}
