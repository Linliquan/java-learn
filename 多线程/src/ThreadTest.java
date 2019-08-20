

public class ThreadTest extends Thread {
    int k = 0;
    @Override
    public  void  run() {

        for (int i = 0; i <200; i++) {
            System.out.println(Thread.currentThread().getName()+" "+k++);
        }
    }

    public static void main(String[] args) {
            ThreadTest threadTest1 = new ThreadTest();
            ThreadTest threadTest2 = new ThreadTest();
            threadTest1.start();

//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
           threadTest2.start();
    }
}
