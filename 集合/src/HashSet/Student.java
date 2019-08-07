package HashSet;

public class Student {
    private int id;
    private String name;

    public Student() {
    }

    @Override
    public int hashCode() {
        return id;
    }


//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("..."+obj.getClass());
        Student s = (Student) obj;
        return s.name.equals(this.name);
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
}
