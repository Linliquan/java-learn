package atomic.t2;

//a++非原子性测试
public class Test {
   public static volatile int  a = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyThread1());
        Thread t2 = new Thread(new MyThread2());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(a);
        System.out.println(a);
    }
}
class MyThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Test.a++;
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            Test.a++;
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}


