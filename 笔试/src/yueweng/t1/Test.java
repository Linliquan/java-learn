package yueweng.t1;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test{

    //可重入锁，jdk1.5引入,通过lock来保证线程的访问的互斥
    private static Lock lock = new ReentrantLock();

    //通过state的值来确定是否打印
    private static int state = 0;

   static class A implements Runnable{

        @Override
        public void run(){
            for(int i = 0; i < 10; ){
                try {
                    lock.lock();
                    //多线程并发不能用if,必须用循环测试等待条件，避免虚假唤醒
                    while(state % 3 == 0){
                        System.out.print("A");
                        state++;
                        i++;
                    }

                }catch (Exception e){

                } finally {
                    lock.unlock();
                }
            }
        }

    }

    static class B implements Runnable{

        @Override
        public void run(){
            for(int i = 0; i < 10; ){
                try {
                    lock.lock();
                    //多线程并发不能用if,必须用循环测试等待条件，避免虚假唤醒
                    while(state % 3 == 1){
                        System.out.print("B");
                        state++;
                        i++;
                    }

                }finally {
                    lock.unlock();
                }
            }
        }

    }

    static class C implements Runnable{

        @Override
        public void run(){
            for(int i = 0; i < 10; ){
                try {
                    lock.lock();
                    //多线程并发不能用if,必须用循环测试等待条件，避免虚假唤醒
                    while(state % 3 == 2){
                        System.out.print("C");
                        Thread.sleep(200);
                        state++;
                        i++;
                    }

                }catch (Exception e){

                } finally {
                    lock.unlock();
                }
            }
        }

    }

    public static void main(String[] args){
       new Thread(new A()).start();
       new Thread(new B()).start();
       new Thread(new C()).start();
//        new A().start();
//        new B().start();
//        new C().start();
    }
}

