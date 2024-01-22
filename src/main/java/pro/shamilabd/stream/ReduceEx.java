package pro.shamilabd.stream;

import pro.shamilabd.lambda.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 15.05.2023
 */
public class ReduceEx {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(8);
        nums.add(2);
        nums.add(4);
        nums.add(3);
        int sum = nums.stream().reduce((accum, element) -> accum * element).get();
        System.out.println(sum);

        List<Student> students = Student.getStudents();
        System.out.println(students);
        Optional<Student> sumCourseStudent = students.stream().reduce((accum, elem) -> {
            accum.setCourse(accum.getCourse() + elem.getCourse());
            return accum;
        });

        if (sumCourseStudent.isPresent()) {
            System.out.println(sumCourseStudent);
        } else {
            System.out.println("No student");
        }
    }
}
