package ThreadPool2.t1;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPool threadPool = new ThreadPool();

        for (int i = 0; i < 5; i++) {
            service.submit(threadPool);
        }
        service.shutdown();
        }
}

class ThreadPool implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
