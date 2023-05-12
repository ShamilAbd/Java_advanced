package com.shamilabd.nestedclass;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 10.05.2023
 */
public class SimpleNestedClass {
    public static void main(String[] args) {
        SimpleNestedClass test = new SimpleNestedClass();
        Stat test2 = new Stat();
//        NonStatic test3 = new NonStatic(); // can't create non static object in static context
        System.out.println(someAction());
    }
    
    public static class Stat {
        boolean weAreHuman;
    }

    public class NonStatic {
        int val;
    }
    
    public static boolean someAction() {
        class InMethod {
            boolean val = true;

            public boolean getVal() {
                return val;
            }
        }

        InMethod test = new InMethod();
        return test.getVal();
    }
}
