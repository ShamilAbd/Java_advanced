package pro.shamilabd.stream;

import pro.shamilabd.lambda.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 15.05.2023
 */
public class MapEx {
    public static void main(String[] args) {
        List<Student> students = Student.getStudents();
        /* map(Function<T,S>)
        Tanya -> 3
        Vasya -> 1
        Sonya -> 4
         */
        List<Integer> nameLenght = students.stream().map(element -> element.getCourse()).collect(Collectors.toList());
        System.out.println(nameLenght);

        int[] nums = {5, 9, 4, 8, 1, 6, 3, 2};
        int[] divTo3 = Arrays.stream(nums).map(operand -> {
            if (operand % 3 == 0) {
                operand /= 3;
            }
            return operand;
        }).toArray();
        // [5, 3, 4, 8, 1, 2, 1, 2]
        System.out.println(Arrays.toString(divTo3));
    }
}
