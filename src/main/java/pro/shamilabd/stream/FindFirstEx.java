package pro.shamilabd.stream;

import pro.shamilabd.lambda.Student;

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
