package com.shamilabd.stream;

import com.shamilabd.lambda.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.05.2023
 */
public class MapToIntEx {
    public static void main(String[] args) {
        List<Integer> courses = Student.getStudents().stream().mapToInt(el -> el.getCourse()).boxed().collect(Collectors.toList());
        System.out.println(courses);
        System.out.println("------------");
        List<Integer> courses2 = Student.getStudents().stream().map(el -> el.getCourse()).collect(Collectors.toList()); // можно и так
        System.out.println(courses2);
        System.out.println("------------");
        int sum = Student.getStudents().stream().mapToInt(el -> el.getCourse()).sum();
        System.out.println(sum);
        System.out.println("------------");
        int min = Student.getStudents().stream().mapToInt(el -> el.getCourse()).min().getAsInt();
        System.out.println(min);
        System.out.println("------------");
        int max = Student.getStudents().stream().mapToInt(el -> el.getCourse()).max().getAsInt();
        System.out.println(max);
        System.out.println("------------");
        double avg = Student.getStudents().stream().mapToInt(el -> el.getCourse()).average().getAsDouble();
        System.out.println(avg);
    }
}
