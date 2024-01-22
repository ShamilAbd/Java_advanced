package pro.shamilabd.generics.example;

public class Game {
    public static void main(String[] args) {
        Team<Schoolar> schoolboys = new Team("O-lo-lo");
        Team<Student> students = new Team("MIAT");
//        Team<Employee> employees = new Team("Old mans"); // not implement Comparable
        Team<Schoolar> schoolboys2 = new Team("E-ge-ge");

        Schoolar schoolboy1 = new Schoolar("Katya", 12);
        Schoolar schoolboy2 = new Schoolar("Petya", 13);
        Student student1 = new Student("Dasha", 20);
        Student student2 = new Student("Sasha", 22);
//        Employee emp1 = new Employee("Mihail", 33);
//        Employee emp2 = new Employee("Vasilii", 45);
        Schoolar schoolboy3 = new Schoolar("Dina", 13);
        Schoolar schoolboy4 = new Schoolar("Anna", 15);

        schoolboys.addPlayer(schoolboy1);
        schoolboys.addPlayer(schoolboy2);
        students.addPlayer(student1);
        students.addPlayer(student2);
//        employees.addPlayer(emp1);
//        employees.addPlayer(emp2);
        schoolboys2.addPlayer(schoolboy3);
        schoolboys2.addPlayer(schoolboy4);

        schoolboys.playResult(schoolboys2);
        schoolboys.playResult(schoolboys2);
        schoolboys.playResult(schoolboys2);
        schoolboys.playResult(schoolboys2);
//        employees.playResult(students); // can't
    }
}
