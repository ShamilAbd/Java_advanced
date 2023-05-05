package com.shamilabd.collection;

import java.util.Stack;
import java.util.Vector;
import static com.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 05.05.2023
 */
public class VectorAndStackEx {

    public static void main(String[] args) {
//        vertorEx();
        stackEx();
    }

    public static void vertorEx() {
        Vector<String> names = new Vector<>();
        names.add("Shamil");
        names.add("Anna");
        names.add("Denis");
        names.add("Petr");
        names.add("Bubba");
        System.out.println(names);
        line();

        names.remove("Shamil");
        names.remove("Bubba");
        System.out.println(names);
        line();

        System.out.println(names.get(0));
        System.out.println(names.get(1));
        line();

        names.add("Shamil");
        names.add("Bubba");
        System.out.println(names);
        line();
        System.out.println(names.firstElement());
        System.out.println(names.lastElement());
        line();
    }

    public static void stackEx() {
        Stack<String> names = new Stack<>();
        names.push("Shamil");
        names.push("Anna");
        names.push("Denis");
        names.push("Petr");
        names.push("Bubba");

        // new in Stack
        System.out.println(names);
        line();
        System.out.println(names.pop()); // get last and remove him - Bubba
        System.out.println(names.pop()); // Petr
        System.out.println(names.pop()); // Denis
        System.out.println(names.peek()); // just get this element - Anna
        System.out.println(names.peek()); // Anna
        System.out.println(names.peek()); // Anna
        System.out.println(names);
        line();

        // next code return EmptyStackException
//        System.out.println(names.pop());
//        System.out.println(names.pop());
        // Now stack is empty
//        System.out.println(names.pop()); // here we get EmptyStackException

        // one of way - use isEmpty()
        while (!names.isEmpty()) {
            System.out.println(names.pop());
        }
    }
}
