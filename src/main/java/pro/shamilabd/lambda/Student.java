package pro.shamilabd.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 15.05.2023
 */
public class Student {
    private String name;
    private int course;
    private int grade;

    public Student(String name, int course, int grade) {
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;

        if (course != student.course || grade != student.grade) {
            return false;
        }
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + course;
        result = 31 * result + grade;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" + name + ", course=" + course + ", grade=" + grade + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public static List<Student> getStudents() {
        Student student1 = new Student("Tanya", 3, 8);
        Student student2 = new Student("Vasya", 1, 6);
        Student student3 = new Student("Sonya", 4, 7);
        Student student4 = new Student("Anna", 3, 7);
        Student student5 = new Student("Petya", 2, 7);
        Student student6 = new Student("Dima", 5, 9);
        Student student7 = new Student("Alesha", 2, 4);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        return students;
    }

}
