package TreeMap;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student() {
    }


    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 自然排序
     *
     */
    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
