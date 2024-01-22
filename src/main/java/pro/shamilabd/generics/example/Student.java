package pro.shamilabd.generics.example;

public class Student extends Player implements Comparable {
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public int compareTo(Object o) {
        return 0; // dummy
    }
}
