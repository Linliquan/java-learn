package StackQueue;

import java.util.Stack;

public class QueueTest {

    //入队
    Stack<Integer> stack1 = new Stack<>();
    //出队
    Stack<Integer> stack2 = new Stack<>();
    private QueueTest queue;

    public void push(int a){
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack2.push(a);
    }

    public int pop(){
        while (!stack1.empty()){
           stack2.push(stack1.pop());
        }
        return stack2.pop();
    }


    public static void main(String[] args) {
        QueueTest queue = new QueueTest();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        System.out.println(queue.pop());

    }

}
