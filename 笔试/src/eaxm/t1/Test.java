package eaxm.t1;

public class Test {
    public  static void  main(String[] args) {
        int [] a = {3,4,5,6,7};
        int [] b = {1,2,3,4,5,6,7};

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i]*b[i];
        }
        for(int i : b){
            System.out.print(i+" ");
        }
    }
}
