package ThreadPool2.t2;



import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {

        //创建线程池
       // ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor poolExecutor =
                new ThreadPoolExecutor(5,10,
                        0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(1024));

        ThreadPool threadPool = new ThreadPool();

        //分配任务
        for (int i = 0; i < 10; i++) {
            poolExecutor.submit(threadPool);
            System.out.println();
        }
        poolExecutor.shutdown();
    }
}

class ThreadPool implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
