package callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//创建多线程3：实现callable接口
public class CallableTest {
    public static void main(String[] args) {
        //执行Callable的方式，需要FutureTask实现，用于接收计算结果
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable());
        new Thread(futureTask).start();

        try {
            Integer sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
