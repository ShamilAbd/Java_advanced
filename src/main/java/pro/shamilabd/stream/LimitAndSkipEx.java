package pro.shamilabd.stream;

import pro.shamilabd.lambda.Student;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.05.2023
 */
public class LimitAndSkipEx {
    public static void main(String[] args) {
        Student.getStudents().stream().forEach(System.out::println);
        System.out.println("--------------");
        Student.getStudents().stream().limit(2).forEach(System.out::println);
        System.out.println("--------------");
        Student.getStudents().stream().skip(2).forEach(System.out::println);
    }
}
