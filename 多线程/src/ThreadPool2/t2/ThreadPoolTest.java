package ThreadPool2.t2;



import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {

        //创建线程池
       // ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor poolExecutor =
                new ThreadPoolExecutor(5,5,
                        0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(1024), Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());

        ThreadPool threadPool = new ThreadPool();

        //分配任务
//        for (int i = 0; i < 1000; i++) {
//            poolExecutor.submit(threadPool);
            poolExecutor.execute(()->{
                for (int i = 0; i < 100000; i++) {
                    System.out.println("哈哈哈 " + Thread.currentThread().getName()+ " " + i);
                }

            });

//            System.out.println("-------" + "第" + i + "次");
//        }
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
