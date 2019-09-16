package Thread;

public class ThreadTest2 {
    public static void main(String[] args) throws Exception {
        My my1 = new My();
        My my2 = new My();
        my1.start();
        my1.join();
        my2.start();

    }
}

class My extends Thread{
    @Override
    public void run() {


        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);

//            //t1、t2线程交替打印
//            try{
//                Thread.sleep(100);
//            }catch(Exception e){
//            }
        }
    }
}
