package HashSet;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set s1 = new HashSet();

        //
        s1.add("tom");
        s1.add(23);
        s1.add(true);
        s1.add(10.99);

        System.out.println(s1);
        System.out.println(s1.size());
        //移除一个元素
        s1.remove(10.99);

        //判断集合中是否包含一个元素
        System.out.println(s1.contains("tom"));

        Set s2 = new HashSet<Student>();
        Student stu1 = new Student(1,"tom");
        Student stu2 = new Student(1,"tom");
        Student stu3 = new Student(1,"tom");

        s2.add(stu1);
        s2.add(stu2);
        s2.add(stu3);

        System.out.println(s2);
        //hashSet 怎么区分对象是否重复
        /**
         * 1.对象中的hashCode()获得hashCode值
         * 2.hashCode值不同，肯定是不同的对象
         * 3,hashCode值相同，再比较equals方法
         * 4.equals相同，对象相同。
         */

    }
}
