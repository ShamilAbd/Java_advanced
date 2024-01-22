package pro.shamilabd.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
/**
 * @author Abdullin Shamil Ildusovich
 * @Date 15.05.2023
 */
public class FunctionEx {
    public static void main(String[] args) {
        Student student1 = new Student("Tanya", 3, 8);
        Student student2 = new Student("Vasya", 1, 6);
        Student student3 = new Student("Sonya", 4, 7);
        Student student4 = new Student("Anna", 3, 7);
        Student student5 = new Student("Petya", 2, 7);
        Student student6 = new Student("Dima", 5, 9);
        Student student7 = new Student("Alesha", 2, 4);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        System.out.println(avgFromStudent(students, (student -> student.getGrade())));
        System.out.println(avgFromStudent(students, (student -> student.getCourse())));
        System.out.println(avgFromStudent(students, (student -> student.getName().length())));
    }

    private static int avgFromStudent(List<Student> students, Function<Student, Integer> function) {
        int result = 0;
        for (Student student : students) {
            result += function.apply(student);
        }
        return result / students.size();
    }
}
