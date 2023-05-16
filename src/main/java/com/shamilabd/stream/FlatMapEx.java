package com.shamilabd.stream;

import com.shamilabd.Utils;
import com.shamilabd.lambda.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.05.2023
 */
public class FlatMapEx {
    public static void main(String[] args) {
        List<Student> students = Student.getStudents();

        Faculty economic = new Faculty("Economic");
        Faculty math = new Faculty("Mathematics");
        economic.addStudentToFaculty(students.get(0));
        economic.addStudentToFaculty(students.get(1));
        economic.addStudentToFaculty(students.get(2));
        economic.addStudentToFaculty(students.get(3));
        math.addStudentToFaculty(students.get(4));
        math.addStudentToFaculty(students.get(5));
        math.addStudentToFaculty(students.get(6));

        List<Faculty> faculties = new ArrayList<>();
        faculties.add(economic);
        faculties.add(math);

        faculties.stream().flatMap(faculty -> faculty.getStudentsOnFaculty().stream()).forEach(e -> System.out.println(e.getName()));

    }
}

class Faculty {
    private String name;
    private List<Student> studentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        this.studentsOnFaculty = new ArrayList<>();
    }

    public List<Student> getStudentsOnFaculty() {
        return new ArrayList<>(studentsOnFaculty);
    }

    public void addStudentToFaculty(Student student) {
        studentsOnFaculty.add(student);
    }
}
