package tongcheng.t1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        My my1 = new My();
        My my2 = new My();
        my1.start();
        my2.start();
    }
}

class My extends Thread{
    @Override
    public void run() {

    }
}
