package com.shamilabd.stream;

import com.shamilabd.Utils;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.05.2023
 */
public class PeekEx {
    public static void main(String[] args) {
        System.out.println(Utils.getIntegers().stream().sorted().distinct().peek(System.out::println).count());
    }
}
