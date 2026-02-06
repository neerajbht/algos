package leetcode;

public class Student implements Comparable<Student> {

    private int id;
    private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;

    }

    @Override
    public int compareTo(Student other) {
        // Returns -1 if this.id < other.id, 0 if equal, 1 if this.id > other.id
        return Integer.compare(this.id, other.id);
    }

}
