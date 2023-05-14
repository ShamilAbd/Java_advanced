package com.shamilabd.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import static com.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 14.05.2023
 */
public class PredicateEx {
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

        System.out.println("Курс больше 3: ");
        testStudend(students, (s) -> s.getCourse() > 3);
        line();
        System.out.println("Оценка 7 и выше: ");
        testStudend(students, (s) -> s.getGrade() >= 7);
        line();
        System.out.println("Имя начинается на А: ");
        testStudend(students, (s) -> s.getName().startsWith("A"));
        line();
        System.out.println("Оценка меньше 7: ");
        Predicate<Student> gradeLessThan7 = student -> student.getGrade() < 7;
        testStudend(students, gradeLessThan7);
        line();
        System.out.println("Курс меньше 4: ");
        Predicate<Student> courseLessThan4 = student -> student.getCourse() < 4;
        testStudend(students, courseLessThan4);
        line();
        System.out.println("Курс меньше 4 и оценка меньше 7: ");
        Predicate<Student> nameFromA = student -> student.getName().startsWith("A");
        testStudend(students, courseLessThan4.and(gradeLessThan7));
        line();
        testStudend(students, courseLessThan4.and(gradeLessThan7.negate()));
        line();
        line();
        System.out.println(students);
        students.removeIf((e) -> e.getGrade() < 7);
        System.out.println(students);
    }

    public static void testStudend(List<Student> list, Predicate<Student> pr) {
        for (Student st : list) {
            if (pr.test(st)) {
                System.out.println(st);
            }
        }
    }
}
