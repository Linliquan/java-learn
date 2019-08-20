package runnable;

public class RunnableTest {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        thread1.start();
        thread2.start();


    }
}
