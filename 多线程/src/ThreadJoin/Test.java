package ThreadJoin;

public class Test {
    public static void main(String[] args) {

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();

        myThread2.start();



    }


}

class MyThread1 extends Thread{
    
    @Override
    public void run(){
        for (int i = 1; i <= 20; i++) {

            if (i == 8){

            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}

class MyThread2 extends Thread{

    @Override
    public void run(){
        for (int i = 1; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
