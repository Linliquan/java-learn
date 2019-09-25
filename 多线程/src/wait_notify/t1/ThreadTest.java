package wait_notify.t1;

//使用wait()和notify()交替打印0 - 100
public class ThreadTest{
    private static final Object lock = new Object();

   static  class ThreadA extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100; i = i+2) {
               synchronized (lock){
                   lock.notify();
                   System.out.println(Thread.currentThread().getName()+" "+i);
                   try {
                       lock.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

               }
            }
        }

    }

    static  class ThreadB extends Thread{
        @Override
        public void run() {
            for (int i = 1; i < 100; i = i+2) {
                synchronized (lock){
                    lock.notify();
                    System.out.println(Thread.currentThread().getName()+" "+i);
                    if(i < 100){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                }
            }

        }

    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
    }
}
