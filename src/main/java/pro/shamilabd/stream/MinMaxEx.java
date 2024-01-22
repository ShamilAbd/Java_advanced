package pro.shamilabd.stream;

import pro.shamilabd.lambda.Student;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.05.2023
 */
public class MinMaxEx {
    public static void main(String[] args) {
        Student min = Student.getStudents().stream().min((st1, st2) -> st1.getCourse() - st2.getCourse()).get();
        System.out.println(min);

        Student max = Student.getStudents().stream().max((st1, st2) -> st1.getCourse() - st2.getCourse()).get();
        System.out.println(max);
    }
}
