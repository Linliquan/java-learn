/**
 * 加了两把锁，
 * 多个线程同时执行
 * T1线程拿到A锁
 *  T1
 */
public class Test {

    //锁A
    public static Object A = new Object();
    //锁B
    public static Object B = new Object();

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }

}

class  T1 extends Thread{
    @Override
    public void run() {
        synchronized(Test.A){
            System.out.println("A");
            synchronized(Test.B){
                System.out.println("核心代码T1");
            }
        }
    }
}

class  T2 extends Thread{
    @Override
    public void run() {
        synchronized(Test.B){
            System.out.println("B");
            synchronized(Test.A){
                System.out.println("T2核心代码");
            }
        }
    }
}
