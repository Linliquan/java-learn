package t1_t2_t3;

import org.omg.PortableServer.THREAD_POLICY_ID;
import runnable.MyThread;

/**
 * @program: java-learn
 * @description: 先后顺序打印 t1 t2 t3
 * @author: liquan
 * @create: 2019-11-25 11:28
 **/
public class Test {
    public static void main(String[] args) throws Exception{
            MyThread1 t1 = new MyThread1();
            MyThread2 t2 = new MyThread2();
            MyThread3 t3 = new MyThread3();
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}

class MyThread3 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}