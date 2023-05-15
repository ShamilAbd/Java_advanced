package com.shamilabd.stream;

import com.shamilabd.lambda.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 15.05.2023
 */
public class FilterEx {
    public static void main(String[] args) {
        List<Student> students = Student.getStudents();
        List<Student> oldCourse = students.stream().filter(student -> student.getCourse() > 3).collect(Collectors.toList()); // Predicate
        System.out.println(oldCourse);

        System.out.println(students);
        students.forEach(e -> e.setCourse(e.getCourse() + 1));
        System.out.println(students);

        Stream<String> myStr = Stream.of("Hello", "Shamil", "From", "Java");
        myStr.forEach(System.out::println);
    }
}
