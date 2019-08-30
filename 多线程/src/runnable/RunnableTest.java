package runnable;

import java.util.Scanner;

public class RunnableTest {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        MyThread3 myThread3 = new MyThread3();

        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        Thread thread3 = new Thread(myThread3);

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();

        System.out.println(str+myThread1.s+myThread2.s+myThread3.s);
    }
}

 class MyThread1 implements Runnable {

    String s =  "_A";

    @Override
    public void run() {

      s = "_A";
    }
}

class MyThread2 implements Runnable {

    String s =  "_B";

    @Override
    public void run() {

        s = "_B";
    }
}

class MyThread3 implements Runnable {

    String s =  "_C";

    @Override
    public void run() {

        s = "_C";
    }
}