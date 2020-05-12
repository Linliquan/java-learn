package ThreadPool2.t3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        MyThreadPool myThreadPool = new MyThreadPool();

        for (int i = 0; i < 5; i++) {
            service.submit(myThreadPool);
        }
        service.shutdown();
    }
}
class MyThreadPool implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
