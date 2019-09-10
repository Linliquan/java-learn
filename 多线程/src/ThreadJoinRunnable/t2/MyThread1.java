package ThreadJoinRunnable.t2;

public class MyThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
