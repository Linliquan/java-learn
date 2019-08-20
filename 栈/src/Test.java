import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int [] a = new int[]{1,4,6,9,2};

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);

        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(stack.pop()+" ");

        }

    }
}
