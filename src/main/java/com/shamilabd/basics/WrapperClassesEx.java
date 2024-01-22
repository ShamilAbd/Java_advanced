package com.shamilabd.basics;

import com.shamilabd.elementary.Utils;

import java.util.ArrayList;
import java.util.List;

import static com.shamilabd.elementary.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 19.04.2023
 */
public class WrapperClassesEx {
    public static void main(String[] args) {
        /*
        Wrappers: Byte, Short, Integer, Long, Float, Double, Char, Boolean
         */
        int val1 = 5;
        Integer val2 = 7;

        List<Integer> vals = new ArrayList<>();
        vals.add(val1); // primitive data type automated autoboxing to his wrapper
        vals.add(val2); // ok

        for (int v : vals) { // here unboxing Integer to int
            System.out.println(v);
        }
        Utils.line();

        // Parsing data
        String intStr = "777";
        int val3 = Integer.parseInt(intStr);
        System.out.println(val3);
        Utils.line();
//        String intStr2 = " 777sdf"; // error! NumberFormatException
//        int val4 = Integer.parseInt(intStr2);
//        System.out.println(val4);

        // WrapperClassName.valueOf(String (or primitive data type) value)
        double d1 = Double.valueOf("25.5");
        System.out.println(d1);
        Utils.line();
    }
}
