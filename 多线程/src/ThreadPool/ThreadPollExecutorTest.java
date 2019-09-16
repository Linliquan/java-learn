package ThreadPool;

import java.util.concurrent.*;

//实现多线程的方式4：创建线程池
public class ThreadPollExecutorTest {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

       // ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);

        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 3; i++) {
            //为线程池分配任务
            executorService.submit(threadPool);
        }
        executorService.shutdown();
    }
}
