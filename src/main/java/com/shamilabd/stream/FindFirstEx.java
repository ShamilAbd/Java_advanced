package com.shamilabd.stream;

import com.shamilabd.Utils;
import com.shamilabd.lambda.Student;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.05.2023
 */
public class FindFirstEx {
    public static void main(String[] args) {
        Student student = Student.getStudents().stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).findFirst().get();
        System.out.println(student);
    }
}
