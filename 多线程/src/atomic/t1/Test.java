package atomic.t1;

//a++ 非原子性测试
public class Test {
    static int  a = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread [] threads = new Thread[2];
        for (int i = 0; i < threads.length; i++) {
            threads [i] = new Thread(){
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        a++;
                    }
                }
            };
            threads[i].start();
        }
        for (Thread thread : threads){
           thread.join();
        }
        System.out.println(a);
    }


}


