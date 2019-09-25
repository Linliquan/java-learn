package abc_sync.t3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//多线程下三个线程循环打印ABC十遍，如ABCABCABC...
//法三：使用jdk1.5的Lock接口的ReentranLock类
public class ABC_Sync {

    private static  Lock lock = new ReentrantLock();
    public static int state = 0;

    static class ThreadA extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try{
                    lock.lock();
                    while (state % 3 == 0){
                        System.out.print("A");
                        state++;
                        i++;
                    }
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }

            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try{
                    lock.lock();
                    while (state % 3 == 1){
                        System.out.print("B");
                        state++;
                        i++;
                    }
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }

            }
        }
    }

    static class ThreadC extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try{
                    lock.lock();
                    while (state % 3 == 2){
                        System.out.print("C");
                        state++;
                        i++;
                    }
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }

            }
        }
    }
    public static void main(String[] args)  {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();

    }
}
