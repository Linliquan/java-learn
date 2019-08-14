public class Test2 {
    public static void main(String[] args) {
        //实现接口的线程 创建 和启动
        Runnable ru = new My3();
        Thread t = new Thread(ru);
        t.start();
    }
}

class My3 implements Runnable{

    @Override
    public void run() {
        System.out.println("...");
    }
}
