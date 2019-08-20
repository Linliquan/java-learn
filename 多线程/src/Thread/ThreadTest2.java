package Thread;

public class ThreadTest2 {
    public static void main(String[] args) {
        My my1 = new My();
        My my2 = new My();
        my1.start();
        my2.start();
    }
}

class My extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
