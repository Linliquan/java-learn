package synchronizeds;

/**
 * @author linliquan
 * @description:
 * @create 2021/7/21 14:35
 */
public class MyThreadTwo extends Thread {

    @Override
    public void run() {
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(Thread.currentThread().getName() + " 快就是慢 " + i);
//        }

//        synchronized (Test.B) {
//            System.out.println("哈哈哈哈 BBB");
//            synchronized (Test.A) {
//                System.out.println("哈哈哈哈 BBB AAA");
//            }
//        }

//        Shop.test();

        Shop shop = new Shop();
        try {
            shop.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
