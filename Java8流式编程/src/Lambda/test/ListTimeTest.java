package Lambda.test;

import Lambda.stream.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author linliquan
 * @description: for遍历执行时间对比
 * @create 2020/12/18 10:01
 */
public class ListTimeTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Student student = new Student();
            student.setAge(i);
            student.setId(i);
            student.setName("a"+i);
            studentList.add(student);
        }

        // for循环
        long timeMillis1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        long endTimeMillis1 = System.currentTimeMillis();
        System.out.println();
        System.out.println("for循环执行时间："+(endTimeMillis1 - timeMillis1) + "ms");

        // for增强
        long timeMillis2 = System.currentTimeMillis();
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        long endTimeMillis2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("for增强执行时间："+(endTimeMillis2 - timeMillis2) + "ms");


        // forEach遍历
        long timeMillis3 = System.currentTimeMillis();
        list.forEach(e -> {
            System.out.print(e + " ");
        });
        long endTimeMillis3 = System.currentTimeMillis();
        System.out.println();
        System.out.println("forEach遍历执行时间："+(endTimeMillis3 - timeMillis3) + "ms");

        // 执行结果，数据量在1000 - 1000000之间内，执行时间：for增强 < for循环 < forEach遍历

        // comparingInt 和 comparing 执行时间比较。结果：comparingInt 执行时间小于 comparing，comparingInt比较好
        long start = System.currentTimeMillis();
        System.out.println("studentNameList2");
        List<Student> studentNameList2 = studentList.stream().sorted(Comparator.comparingInt(Student::getAge).reversed()).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println(end - start +"ms");

        // 5.4
        long start2 = System.currentTimeMillis();
        System.out.println("studentNameList3");
        List<Student> studentNameList3 = studentList.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2 +"ms");

    }


}
