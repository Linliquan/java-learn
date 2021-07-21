package synchronizeds;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * @author linliquan
 * @description:
 * @create 2021/7/21 15:08
 */
public class Shop {

    public int shopCode = 0;

    public String shopName;

    public static int a = 0;

    public int getShopCode() {
        return shopCode;
    }

    public void setShopCode(int shopCode) {
        this.shopCode = shopCode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public  void test() throws InterruptedException {
        synchronized(Thread.class) {
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + " 快就是慢 " + i);
            }
            this.wait();
        }

    }




}
