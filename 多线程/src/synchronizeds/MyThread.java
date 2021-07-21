package synchronizeds;

/**
 * @author linliquan
 * @description:
 * @create 2021/7/21 14:30
 */
public class MyThread extends Thread {

    @Override
    public void run() {
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(Thread.currentThread().getName() + " 十年一梦 " + i);
//        }

//        synchronized (Test.A) {
//            System.out.println(Thread.currentThread().getName() + " 十年一梦 ");
//            System.out.println("哈哈哈 AAA");
//            synchronized (Test.B){
//                System.out.println("哈哈哈 AAA BBB");
//            }
//        }

//        synchronized (Test.class) {
//            for (int i = 1; i <= 10; i++) {
//                System.out.println(Thread.currentThread().getName() + " 十年一梦 " + i);
//            }
//        }
//        System.out.println("呵呵呵");

//        MyThread.synTest();
        Shop shop = new Shop();
        try {
            shop.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

//    public  synchronized static void synTest() {
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(Thread.currentThread().getName() + " 十年一梦 " + i);
//        }
//    }

}
