package TreeSet;


import StudentAddress.Student;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet2 {
    static class Inner{
        public static void main(String[] args) {

            TreeSet<Student> treeSet = new TreeSet<>(Comparator.comparing(Student::getId));
            Student stu = new Student();
            stu.setId(1);
            stu.setName("tom");
            Student stu2 = new Student();
            stu2.setId(2);
            stu2.setName("hey");
            treeSet.add(stu);
            treeSet.add(stu2);
            Student stu3 = new Student();
            stu3.setId(2);
            stu3.setName("cat");
            treeSet.add(stu3);

            for (Student student : treeSet) {
                System.out.println(student);
            }


        }
    }
}
