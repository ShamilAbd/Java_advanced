package pro.shamilabd.stream;

import pro.shamilabd.Utils;
import pro.shamilabd.lambda.Student;
import static pro.shamilabd.Utils.line;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.05.2023
 */
public class SortedEx {
    public static void main(String[] args) {
        int[] nums = Utils.getInts();
        System.out.println(Arrays.toString(nums));
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        System.out.println(Arrays.toString(sortedNums));
        line();

        List<Student> students = Student.getStudents();
        System.out.println(students);
        List<Student> sortedStudents = students.stream().sorted((st1, st2) -> st1.getName().compareTo(st2.getName())).collect(Collectors.toList());
        System.out.println(sortedStudents);
    }
}
