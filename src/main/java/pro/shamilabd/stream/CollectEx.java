package pro.shamilabd.stream;

import pro.shamilabd.lambda.Student;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.05.2023
 */
public class CollectEx {
    public static void main(String[] args) {
        List<Student> students = Student.getStudents();
        Map<Integer, List<Student>> courseGroup = students.stream().map(element -> {
                element.setName(element.getName().toUpperCase(Locale.ROOT));
                return element;
            }).collect(Collectors.groupingBy(el -> el.getCourse()));
        System.out.println(courseGroup);
        System.out.println();

        Map<Boolean, List<Student>> partitionByGrade = students.stream().map(element -> {
            element.setName(element.getName().toUpperCase(Locale.ROOT));
            return element;
        }).collect(Collectors.partitioningBy(el -> el.getGrade() > 7));
        System.out.println(partitionByGrade);

    }
}
