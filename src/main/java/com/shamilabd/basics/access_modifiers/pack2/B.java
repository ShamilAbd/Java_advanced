package com.shamilabd.basics.access_modifiers.pack2;

import com.shamilabd.basics.access_modifiers.pack1.A;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 11.04.2023
 */
public class B {
    public static void main(String[] args) {
        System.out.println("B class in same pack, not extend A");
        A b1 = new A(1);        // I can see public constructor from anywhere
//        A b2 = new A(2.2);        // I can't can see default constructor in extends class in this pack
//        A b3 = new A(true);       // I can't see protected constructor in extends class in this pack
//        A b4 = new A("private");  // I can't call private constructor
        System.out.println(b1.a);   // I can see public field from anywhere
//        System.out.println(b1.b); // I can't see default field in extends class in this pack
//        System.out.println(b1.c); // I can't see protected field in extends class in this pack
//        System.out.println(b1.d); // I can't see private field
        b1.method(1);           // I can see public methods from anywhere
//        b1.method(2.0);           // I can't see default methods
//        b1.method(true);          // I can't see protected methods
//        b1.method("hello");       // I can't see private methods
    }
}


class E extends A {
    public E(int val) {
        super(val);
    }

    protected E(boolean val) {
        super(val);
    }


    public static void main(String[] args) {
        System.out.println("E class in same pack, not extend A");
        E b1 = new E(1);        // I can see public constructor from anywhere
        E b3 = new E(true);     // I can see protected constructor in extends class in this pack
//        E b2 = new E(2.2);        // I can't can see default constructor in extends class in this pack
//        E b4 = new E("private");  // I can't call private constructor
        System.out.println(b1.a);   // I can see public field from anywhere
        System.out.println(b1.b);   // I can  see protected field in extends class in this pack
//        System.out.println(b1.c); // I can't see default field in extends class in this pack
//        System.out.println(b1.d); // I can't see private field
        b1.method(1);           // I can see public methods from anywhere
        b3.method(true);         // I can see protected methods in chield class from other pack
//        b1.method(2.0);           // I can't see default methods in other pack
//        b1.method("hello");       // I can't see private methods
    }
}
