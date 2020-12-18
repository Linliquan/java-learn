package Lambda.stream;

import java.util.*;
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
                add(new Student(20161002, "元直", 20, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 18, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };

        /**
         * 各种骚操作
         */
        // 1 过滤
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

        // 2 映射 在SQL中，借助SELECT关键字后面添加需要的字段名称，可以仅输出我们需要的字段数据，而流式处理的映射操作也是实现这一目的，
        // 在java8的流式处理中，主要包含两类映射操作：map和flatMap。

        // 2.1 map ，假设我们希望筛选出所有专业为计算机科学的学生姓名，那么我们可以在filter筛选的基础之上，通过map将学生实体映射成为学生姓名字符串
        List<String> nameList = studentList.stream().filter(student -> "计算机科学".equals(student.getMajor())).map(Student::getName).collect(Collectors.toList());
        nameList.forEach(e -> {
            System.out.println(e);
        });
        System.out.println();

        // 计算所有专业为计算机科学学生的年龄之和
        int ageSum = studentList.stream().filter(student -> "计算机科学".equals(student.getMajor())).mapToInt(Student::getAge).sum();
        System.out.println(ageSum);
        System.out.println();

        // flatMap flatMap与map的区别在于 flatMap是将一个流中的每个值都转成一个个流，然后再将这些流扁平化成为一个流
        // 假设我们有一个字符串数组String[] strs = {"java8", "is", "easy", "to", "use"};，我们希望输出构成这一数组的所有非重复字符，
        // 那么我们可能首先会想到如下实现：
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String[]> stringsList = Arrays.stream(strs).map(str -> str.split("")).collect(Collectors.toList());
        stringsList.forEach(strings -> {
            for (int i = 0; i < strings.length; i++) {
                System.out.print(strings[i] + " ");
            }
            System.out.println();
        });

        List<String> distinctStr = Arrays.stream(strs).map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println();
        distinctStr.forEach(s -> System.out.print(s));
        System.out.println();

        List<Student> collect = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println();

        // 3 终端操作
        // 3.1 allMatch 全部匹配
        boolean allMatch = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).limit(2)
                .allMatch(student -> student.getAge() == 20);
        System.out.println(allMatch);

        // 3.2 anyMatch 一个或多个满足
        boolean ageIs18 = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).anyMatch(student -> student.getAge() == 18);
        System.out.println(ageIs18);

        // 3.3 noneMathch 不存在，不满足
        boolean noneMatch = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).noneMatch(student -> student.getAge() == 18);
        System.out.println(noneMatch);

        // 3.4 findFirst 返回满足的第一个
        Optional<Student> first = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).findFirst();
        System.out.println(first);
        System.out.println();

        // 3.5 findAny 返回任意一个
        Optional<Student> any = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).findAny();
        System.out.println(any);
        System.out.println();

        // 3.6 reduce 归约
        Integer ageReduce = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).map(Student::getAge).reduce(0, (a, b) -> a + b);
        System.out.println(ageReduce);
        System.out.println();

        Integer ageReduce2 = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).map(Student::getAge).reduce(0, Integer::sum);
        System.out.println(ageReduce2);
        System.out.println();

        // 4 收集
        // 4.1 归约 求学生的总人数
        Long studentCount = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).count();
        System.out.println(studentCount);

        // 4.2 求年龄的最大值和最小值
        Optional<Student> ageMax = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
        System.out.println(ageMax);

        // 4.3 求最小年龄
        Optional<Student> ageMax2 = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).min(Comparator.comparing(Student::getAge));
        System.out.println(ageMax2);

        // 4.4 求年龄总和
        Integer ageTotal = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).collect(Collectors.summingInt(Student::getAge));
        System.out.println(ageTotal);

        Integer ageTotal2 = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).mapToInt(Student::getAge).sum();
        System.out.println(ageTotal2);

        // 4.5 求年龄的平均值
        double avgAge = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).collect(Collectors.averagingInt(Student::getAge));
        System.out.println(avgAge);

        // 4.6 一次性得到年龄的个数、总和、均值、最大值、最小值
        IntSummaryStatistics summaryStatistics = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).collect(Collectors.summarizingInt(Student::getAge));
        System.out.println(summaryStatistics);

        // 4.7 字符串拼接
        String name = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).map(Student::getName).collect(Collectors.joining());
        System.out.println(name);

        // 4.8 字符串拼接, 逗号分隔
        String name2 = studentList.stream().filter(student -> "土木工程".equals(student.getMajor())).map(Student::getName).collect(Collectors.joining(","));
        System.out.println(name2);

    }
}
