package com.shamilabd.basics.access_modifiers.pack1;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 11.04.2023
 */
public class A {
    public int a;
    protected int b;
    int c;
    private int d;

    public A(int val){
        System.out.println("public constructor");
    }

    A(double val){
        System.out.println("default constructor");
    }

    protected A(boolean val){
        System.out.println("protected constructor");
    }


    private A(String val){
        System.out.println("private constructor");
    }


    public void method(int val){
        System.out.println("protected method");
    }

    void method(double d){
        System.out.println("protected method");
    }

    protected void method(boolean b){
        System.out.println("protected method");
    }

    private void method(String val){
        System.out.println("protected method");
    }

    private class InnerClass {
        int val;

        public int some(){
            int val = 5; // doesn't have access modifier
            return val;
        }
    }
}

class C {
    public static void main(String[] args) {
        System.out.println("C class in same pack, not extend A");
        A c1 = new A(1);        // I can see public constructor from anywhere
        A c2 = new A(2.2);      // I can see default constructor in NOT extends class in this pack
        A c3 = new A(true);     // I see protected constructor in NOT extends class in this pack
//        A c4 = new A("private");  // I can't call private constructor
        System.out.println(c1.a);   // I can see public field from anywhere
        System.out.println(c1.b);   // I can see default field in NOT extends class in this pack
        System.out.println(c1.c);   // I see protected field in NOT extends class in this pack
//        System.out.println(c1.d); // I can't see private field
        c1.method(1);           // I can see public methods from anywhere
        c1.method(2.0);          // I can see default methods in NOT extends class in this pack
        c1.method(true);         // I see protected methods in NOT extends class in this pack
//        c1.method("hello");       // I can't see private methods
    }

}

class D extends A {
    public D(int val) {
        super(val);
    }

    D(double val) {
        super(val);
    }


    public static void main(String[] args) {
        System.out.println("D class in same pack, extend A");
        A d1 = new A(1);         // I can see public constructor from anywhere
        A d2 = new A(2.2);       // I can see default constructor in extends class in this pack
        A d3 = new A(true);      // I see protected constructor in extends class in this pack
//        A d4 = new A("private");   // I can't call private constructor
        System.out.println(d1.a);    // I can see public field from anywhere
        System.out.println(d1.b);    // I can see default field in extends class in this pack
        System.out.println(d1.c);    // I see protected field in extends class in this pack
//        System.out.println(d1.d);  // I can't see private field
        d1.method(1);            // I can see public methods from anywhere
        d1.method(2.0);           // I can see default methods in extends class in this pack
        d1.method(true);          // I see protected methods in extends class in this pack
//        d1.method("hello");        // I can't see private methods
    }
}