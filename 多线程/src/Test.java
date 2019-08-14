public class Test {
    public static void main(String[] args) {
//        String name = Thread.currentThread().getName();
//        System.out.println(name);



        //多个线程同时执行代码
        My2 m1 = new My2();
        My2 m2 = new My2();

        //开启线程
        m1.start();
        m2.start();

    }
}

class My2 extends Thread{

    //重写，异常不能被放大，权限不能被缩小,故run
    @Override
    public void run() {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(getName()+" "+i);
//
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
