package com.shamilabd.basics;

import com.shamilabd.elementary.Utils;

import java.util.Random;

import static com.shamilabd.elementary.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 12.04.2023
 */
public class Cycles {
    public static void main(String[] args) {
        // FOR studying section
        for (int i = 0; i < 5; i++)
            System.out.println(i); // one statement in for
        Utils.line();

        for (int i = 0; i < 5; i++) { // more than one statement in for required { and }
            System.out.println(i);
            Utils.line();
        }
        // i scope only in for cycle
//        i = 5;
        Utils.line();

        for (int i = 0, j = 4; i < 15 && j >= 0; i += 3, j--, System.out.println(i)) // multi init
            System.out.println("i = " + i + ", j = " + j);
        Utils.line();

        int i = 0;
        for (; ; ) {// empty for
            if (i > 5) break;  // used break for exit from loop
            System.out.println(i++);
        }
        Utils.line();
//        for (int j = 0; false; j++) { //unreachable statement
//            System.out.println(j);
//        }
        // but "if" is exception in rules
        if (false) System.out.println("we can write that");

        Random random = new Random();
        int col;
        for (int j = 1; j <= 10; j++) { // nested for loop
            col = random.nextInt(10) + 1;
            for (int k = 1; k <= 10; k++) {
                if (k == col) {
                    System.out.print(j + " * " + k + " = (?)" + "\t");
                    continue; // used continue for skip one iteration in loop
                }
                System.out.print(j + " * " + k + " = " + j * k + "\t");
            }
            System.out.println();
        }
        Utils.line();

        OUTER_LOOP:
        // mark
        for (int j = 0; j < 10; j++) {
            INNER_LOOP:
            // mark
            for (int k = 0; k < 10; k++) {
                System.out.print(j * k + "\t");
                if (j == 6 && k == 5) break OUTER_LOOP; // break to mark
            }
            System.out.println();
        }
        Utils.line(true);

        //------------------------------------------------------------------------------------
        // WHILE studying section

        i = 0;
        while (i < 10) {
            if (i == 5) {
                i++;
                continue;
            }
            if (i == 8) {
                i++;
                break;
            }
            System.out.println(i++);
        }
        Utils.line();

        i = 0;
        int j = 0;
        OUTER_WHILE:
        while (i < 4) {
            i++;
            System.out.println(i);
            j = 0;
            INNER_WHILE:
            // for init sample
            while (j < 5) {
                if (j == 3) {
                    continue OUTER_WHILE; // Все как и в for
                }
                System.out.println("\t" + j++);
            }
        }
        Utils.line();

        i = 0;
        do {
            System.out.println(i++); // будет выведено хотя бы 1 раз
        } while (i > 10); // false!!!
        line();

        //------------------------------------------------------------------------------------
        // Mega combine
        i = 0;
        j = 5;
        do {
            System.out.println("i = " + i);
            j = i;
            while (j < 5) {
                System.out.println("  j = " + j);
                for (int k = 0; k < 3; k++) {
                    System.out.println("    k = " + k);
                }
                j++;
            }
        } while (++i < 5);
        line();


        //------------------------------------------------------------------------------------
        // Java 1.5
        // можно использовать с массивами и с теми, кто реализует интерфейс java.lang.Iterable
        // foreach sample
        int[] intArray = {0, 2, 4, 5, 6, 8, 15, 22, 1, 0, 5, 11};

        for (int value : intArray) {
            System.out.println(value);
        }
        line();

        String[] strArr = {"My", "name", "is", "Shamil"};
        for (String str : strArr) {
            System.out.print(str + " ");
        }
        line(true);
    }
}
