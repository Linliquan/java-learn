package callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Integer call() throws Exception {
       int sum = 0;
        for (int i = 0; i < 20; i++) {
            sum += i;
        }
        return sum;
    }
}
