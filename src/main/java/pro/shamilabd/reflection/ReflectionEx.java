package pro.shamilabd.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static pro.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 04.06.2023
 */
public class ReflectionEx {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // 3 способа получения класса
//        Class employeeClass = Employee.class;
//        Employee emp = new Employee();
//        Class employeeClass = emp.getClass();
        Class employeeClass = Class.forName("pro.shamilabd.reflection.Employee");

        // Получения поля
        Field field = employeeClass.getField("id");
        System.out.println("Type of id field: " + field.getType());
        line();

        // Получение полей класса
        Field[] fields = employeeClass.getFields(); // без приватных
        for (Field field1 : fields) {
            System.out.println("Field of \"" + field1.getName() + "\" = " + field1.getType());
        }
        line();

        Field[] allFields = employeeClass.getDeclaredFields();
        for (Field field1 : allFields) {
            System.out.println("Field of \"" + field1.getName() + "\" = " + field1.getType());
        }
        line();

        // Метод(ы)
        Method method = employeeClass.getMethod("increaseSalary");
        System.out.println("Return type of method " + method.getName() + " = " + method.getReturnType() + ", "
                + "parameter types: " + Arrays.toString(method.getParameterTypes()));

        Method methodSetSalary = employeeClass.getMethod("setSalary", double.class);
        System.out.println("Return type of method " + methodSetSalary.getName() + " = " + methodSetSalary.getReturnType() + ", "
                + "parameter types: " + Arrays.toString(methodSetSalary.getParameterTypes()));
        line();

        Method[] methods = employeeClass.getMethods(); // без приватных
        for (Method method1 : methods) {
            System.out.println("Return type of method " + method1.getName() + " = " + method1.getReturnType() + ", "
                    + "parameter types: " + Arrays.toString(method1.getParameterTypes()));
        }
        line();

        Method[] allMethods = employeeClass.getDeclaredMethods();
        for (Method method1 : allMethods) {
            System.out.println("Return type of method " + method1.getName() + " = " + method1.getReturnType() + ", "
                    + "parameter types: " + Arrays.toString(method1.getParameterTypes()));
        }
        line();

        allMethods = employeeClass.getDeclaredMethods();
        for (Method method1 : allMethods) {
            if (Modifier.isPublic(method1.getModifiers())) {
                System.out.println("Return type of method " + method1.getName() + " = " + method1.getReturnType() + ", "
                        + "parameter types: " + Arrays.toString(method1.getParameterTypes()));
            }
        }
        line();

        // Конструкторы
        Constructor constructor1 = employeeClass.getConstructor();
        System.out.println("Constructor " + constructor1.getName() + " has " + constructor1.getParameterCount() + " "
                + " parameters, their types are: " + Arrays.toString(constructor1.getParameterTypes()));
        line();

        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        System.out.println("Constructor " + constructor2.getName() + " has " + constructor2.getParameterCount() + " "
                + " parameters, their types are: " + Arrays.toString(constructor2.getParameterTypes()));
        line();

        Constructor[] allConstructor = employeeClass.getConstructors();
        for (Constructor csr : allConstructor) {
            System.out.println("Constructor " + csr.getName() + " has " + csr.getParameterCount() + " "
                    + " parameters, their types are: " + Arrays.toString(csr.getParameterTypes()));
        }
        line();

        allConstructor = employeeClass.getDeclaredConstructors();
        for (Constructor csr : allConstructor) {
            System.out.println("Constructor " + csr.getName() + " has " + csr.getParameterCount()
                    + " parameters, their types are: " + Arrays.toString(csr.getParameterTypes()));
        }
        line();
    }
}

class Employee {
    public int id;
    public String name;
    public String department;
    private double salary;
    private int secret = 666;

    public Employee() {
    }

    private Employee(int id, String name) {
        this(id, name, null, 0.0);
    }

    public Employee(int id, String name, String department) {
        this(id, name, department, 0.0);
    }

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private void changeDepartment(String newDepartment) {
        department = newDepartment;
        System.out.println("New department is " + newDepartment);
    }

    public void increaseSalary() {
        salary *= 2;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", department='" + department + '\''
                + ", salary=" + salary + '}';
    }
}
