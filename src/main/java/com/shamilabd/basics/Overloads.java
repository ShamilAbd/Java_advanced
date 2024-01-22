package com.shamilabd.basics;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 11.04.2023
 */
public class Overloads {
    // Разные по количеству параметров
    public Overloads() {
        this(3);
        System.out.println("Simple constructor");
    }

    public Overloads(int val, char myChar) {
        System.out.println("Constructor with 2 params");
    }

    // Разные по типам переменных
    public Overloads(byte val) {
        System.out.println("byte constructor");
    }

    public Overloads(short val) {
        System.out.println("short constructor");
    }

    public Overloads(int val) {
        System.out.println("int constructor");
    }

    public Overloads(long val) {
        System.out.println("long constructor");
    }

    public Overloads(float val) {
        System.out.println("float constructor");
    }

    public Overloads(double val) {
        System.out.println("double constructor");
    }

    public Overloads(boolean val) {
        System.out.println("boolean constructor");
    }

    // Разные по порядку следования типов
    public Overloads(byte val, int val2) {
        System.out.println("byte constructor");
    }

    public Overloads(int val2, byte val) {
        System.out.println("byte constructor");
    }


    public static int sum() {
        System.out.println("Without param");
        return 0;
    }

    public static int sum(int val) {
        System.out.println("With 1 param");
        return val;
    }

    public static int sum(int val1, int val2) {
        System.out.println("With 2 params");
        return val1 + val2;
    }

    public static int sum(int val1, int val2, int val3) {
        System.out.println("With 3 params");
        return sum(val1, val2) + val3;
    }

    public static int sum(int val1, int val2, int val3, int val4) {
        System.out.println("With 4 params");
        return sum(val1, val2, val3) + val4;
    }

    public static int sum(int... val) {
        System.out.println("With VarArgs");
        int result = 0;
        for (int i : val) {
            result += i;
        }
        return result;
    }

    public static int sum(String summa) {
        System.out.println("With String param");
        String[] nums = summa.split("\\D+");

        int result = 0;
        for (String ints : nums) {
            result += Integer.parseInt(ints);
        }
        return result;
    }
}

class OverloadTest {
    // Here is the default constructor

    public static void main(String[] args) {
        Overloads o = new Overloads();
        Overloads o1 = new Overloads((byte) 1);
        Overloads o2 = new Overloads((short) 2);
        Overloads o3 = new Overloads(3);
        Overloads o4 = new Overloads(4L);
        Overloads o5 = new Overloads(5F);
        Overloads o6 = new Overloads(6.0);
        Overloads o7 = new Overloads(true);
        Overloads o8 = new Overloads(7, 'V');

        System.out.println(Overloads.sum());
        System.out.println(Overloads.sum(7));
        System.out.println(Overloads.sum(2, 3));
        System.out.println(Overloads.sum(1, 2, 3));
        System.out.println(Overloads.sum(1, 2, 3, 4));
        System.out.println(Overloads.sum(2, 2, 2, 2, 2, 2, 2, 2, 3));
        System.out.println(Overloads.sum("2+: 2 3!\"№; %:? *() - =  4      ")); // Hard test :)
    }
}