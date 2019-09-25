package abc_sync.t2;

//多线程下三个线程循环打印ABC十遍，如ABCABCABC...
//法二：使用synchronized、wait()和notify()实现
public class ABC_Sync {

 public static class ThreadPrinter implements Runnable{
     private String name;
     private Object prev;
     private Object self;

     private ThreadPrinter(String name,Object prev,Object self){
         this.name = name;
         this.prev = prev;
         this.self = self;
     }
     @Override
     public void run() {
         int i = 10;
         while (i > 0){
             synchronized(prev){
                 synchronized (self){
                     System.out.print(name);
                     self.notifyAll();
                     i--;
                 }
                 try {
                     if(i == 0){
                         prev.notifyAll();
                     }else {
                         prev.wait();
                     }

                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }
 }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        new Thread(new ThreadPrinter("A",c,a)).start();
        Thread.sleep(100);
        new Thread(new ThreadPrinter("B",a,b)).start();
        Thread.sleep(100);
        new Thread(new ThreadPrinter("C",b,c)).start();

    }
}
