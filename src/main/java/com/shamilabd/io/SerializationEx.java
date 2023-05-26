package com.shamilabd.io;

import com.shamilabd.generics.example.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 26.05.2023
 */
public class SerializationEx {
    public static void main(String[] args) {
        serializeObj();
        deserializeObj();
    }

    private static void serializeObj() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Shoma", 31, 777_000));
        employees.add(new Employee("Anna", 25, 150_000));
        employees.add(new Employee("Dima", 99, 2_000_000));

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("io_files\\employee.bin"))) {
            objectOutputStream.writeObject(employees);
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializeObj() {
        List<Employee> employees;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("io_files\\employee.bin"))) {
            employees = (List<Employee>) objectInputStream.readObject();
            System.out.println(employees);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
