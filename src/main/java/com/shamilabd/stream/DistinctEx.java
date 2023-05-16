package com.shamilabd.stream;

import com.shamilabd.Utils;

import java.util.stream.Stream;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.05.2023
 */
public class DistinctEx {
    public static void main(String[] args) {
        Utils.getIntegers().stream().sorted().distinct().forEach(System.out::println);
    }
}
