package Lambda.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author linliquan
 * @description: java8 流式处理
 * @create 2020/12/18 14:17
 */
public class Test {
    public static void main(String[] args) {
        // 初始化
        List<Student> studentList = new ArrayList<Student>() {
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 18, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };

        /**
         * 各种骚操作
         */
        // 1.1 filter 过滤
        List<Student> filterList = studentList.stream().filter(student -> "武汉大学".equals(student.getSchool())).collect(Collectors.toList());
        filterList.forEach(System.out::println);
        System.out.println();

        // 1.2 distinct 去重
        List<Student> ageList = studentList.stream().filter(student -> student.getAge() % 2 == 0).distinct().collect(Collectors.toList());
        ageList.forEach(System.out::println);
        System.out.println();

        // 1.3 limit
        List<Student> limitList = studentList.stream().filter(student -> student.getAge() % 2 == 0).distinct().limit(2).collect(Collectors.toList());
        limitList.forEach(System.out::println);
        System.out.println();

        // 1.4 sorted 筛选出专业为土木工程的学生，并按年龄从小到大排序，筛选出年龄最小的两个学生，那么可以实现为：
        List<Student> sortedList = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).sorted(Comparator.comparingInt(Student::getAge)).limit(2).collect(Collectors.toList());
        sortedList.forEach(System.out::println);
        System.out.println();

        // 1.5 skip 跳过 skip操作与limit操作相反，如同其字面意思一样，是跳过前n个元素
        List<Student> skipList = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).sorted(Comparator.comparingInt(Student::getAge).reversed()).limit(2).collect(Collectors.toList());
        skipList.forEach(System.out::println);
        System.out.println();



    }
}
