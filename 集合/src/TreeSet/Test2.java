package TreeSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test2 {
    public static void main(String[] args) {

        Comparator<String> comp = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
               int length1 = o1.length(); //hello world 11
               int length2 = o2.length(); //tom 3

                if ("tom".equals(o1)){
                    return -1;
                }


                return length2 -length1; //负数
            }
        };

        Set<String> s3 = new TreeSet<>(comp);

        s3.add("tom");
        s3.add("hello word");
        s3.add("lisi");
        s3.add("wangwu");

        System.out.println(s3);
        //1234567890 作业
        //偶数升序 奇数降序
        //2 4 6 8  10 9 7 5 3 1

    }
}
