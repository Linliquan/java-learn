package ThreadJoinRunnable.t1;

public class Test {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+" "+i);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    if(i == 8){
                        try {
                            thread1.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+" "+i);
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
