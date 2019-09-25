package abc_sync.t1;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC_Sync {
    //多线程下三个线程循环打印ABC十遍，如ABCABCABC...

   // private static Lock lock = new ReentrantLock();

    //法一
    private static int state = 0;

    static class A extends Thread{
        @Override
        public void run() {

            for (int i = 0; i < 10; ) {

                while (state %3 == 0){
                    System.out.print("A");
                    state++;
                    i++;
                }
            }
        }
    }

    static class B extends Thread{
        @Override
        public void run() {

            for (int i = 0; i < 10; ) {

                while (state %3 == 1){
                    System.out.print("B");
                    state++;
                    i++;
                }
            }
        }
    }

    static class C extends Thread{
        @Override
        public void run() {

            for (int i = 0; i < 10;) {

                while (state %3 == 2){
                    System.out.print("C");
                    state++;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        new A().start();
        new B().start();
        new C().start();
    }
}
