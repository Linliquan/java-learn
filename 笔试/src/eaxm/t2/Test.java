package eaxm.t2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//找出最大值和最小值
public class Test {
    public static void main(String[] args) {
        int [][] a ={{3,2,6},{6,8,2,10},{5},{12,3,23}};

    //    ArrayList<Integer> list = new ArrayList<>();
        int mix = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            //子数组的长度：a[i].length
            for (int j = 0; j < a[i].length; j++) {
          //      list.add(a[i][j]);
                if(mix > a[i][j] ){
                    mix = a[i][j];
                }
                if(max < a[i][j] ){
                    max = a[i][j];
                }
            }
        }
        System.out.println(mix + " " + max);

//        Collections.sort(list);
//        System.out.println(list.get(0));
//        System.out.println(list.get(list.size()-1));

    }
}
