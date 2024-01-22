package pro.shamilabd.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 05.06.2023
 */
public class CreateClassEx {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class employeeClass = Class.forName("pro.shamilabd.reflection.Employee");
//        Employee emp = (Employee) employeeClass.newInstance(); // old way
        Constructor<Employee> constructor = employeeClass.getConstructor();
        Employee employee = constructor.newInstance();

        Constructor constructor1 = employeeClass.getConstructor(int.class, String.class, String.class);
        Object obj = constructor1.newInstance(5, "Shamil", "IT");
        System.out.println(obj);

        Method methodSalary = employeeClass.getMethod("setSalary", double.class);
        methodSalary.invoke(obj, 777999.55);
        System.out.println(obj);

        // See secret field
        Field field = employeeClass.getDeclaredField("secret");
        field.setAccessible(true);
        int secretFieldValue = (int) field.get(obj);
        System.out.println(secretFieldValue);

        Field salary = employeeClass.getDeclaredField("salary");
        salary.setAccessible(true);
        salary.set(obj, 777.7);
        System.out.println(obj);
    }
}
