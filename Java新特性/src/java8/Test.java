package java8;

import java.util.Comparator;
import java.util.TreeSet;

//java8新特性，lambda表达式
public class Test {
    public static void main(String[] args) throws Exception {
        Comparator<String> c = new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return o1.length() -o2.length();
            }
        };

        TreeSet<String> set = new TreeSet<>(c);

        //函数式编程
        Comparator<String> d= (o1,o2) -> o2.length()-o1.length();

        TreeSet<String> set2 = new TreeSet<>(d);

    }
}
