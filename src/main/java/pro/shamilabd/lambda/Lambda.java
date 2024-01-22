package pro.shamilabd.lambda;

import java.util.Collections;
import java.util.List;
import static pro.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 14.05.2023
 */
public class Lambda {
    public static void main(String[] args) {
        List<Student> students = Student.getStudents();

        System.out.println("Курс больше 3: ");
        checkStudent(students, (s) -> s.getCourse() > 3);
        line();
        System.out.println("Оценка 7 и выше: ");
        checkStudent(students, (s) -> s.getGrade() >= 7);
        line();
        System.out.println("Имя начинается на А: ");
        checkStudent(students, (s) -> s.getName().startsWith("A"));
        line();
        System.out.println("Оценка меньше 7: ");
        checkStudent(students, (s) -> s.getGrade() < 7);
        line();
        System.out.println("Курс меньше 4: ");
        checkStudent(students, (s) -> s.getCourse() < 4);
        line();
        line();

        System.out.println(students);
        Collections.sort(students, (s1, s2) -> s1.getCourse() - s2.getCourse());
//        Collections.sort(students, Comparator.comparingInt(Student::getCourse));
        System.out.println(students);
    }

    public static void checkStudent(List<Student> list, StudentCheck sc) {
        for (Student s : list) {
            if (sc.test(s)) {
                System.out.println(s);
            }
        }
    }
}

interface StudentCheck {
    boolean test(Student s);
}