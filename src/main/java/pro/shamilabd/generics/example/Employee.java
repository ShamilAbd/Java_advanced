package pro.shamilabd.generics.example;

import java.io.Serial;

public class Employee extends Player {
    @Serial
    private static final long serialVersionUID = 1L;
    private transient int salary;

    public Employee() {
        super(null, 0);
    }

    public Employee(String name, int age) {
        super(name, age);
    }

    public Employee(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + getName() + ", " + getAge() + ", salary: " + salary + "}";
    }
}
