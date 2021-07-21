package synchronizeds;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * @author linliquan
 * @description:
 * @create 2021/7/21 14:28
 */
public class Test {

    public static final Object A = new Object();
    public static final Object B = new Object();

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThreadTwo myThread2 = new MyThreadTwo();
//        MyThreadTwo myThreadTwo = new MyThreadTwo();
        myThread.start();
        myThread2.start();

//        myThreadTwo.start();
    }
}
