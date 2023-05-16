package com.shamilabd.stream;

import com.shamilabd.Utils;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.05.2023
 */
public class ConcatEx {
    public static void main(String[] args) {
        Stream<Integer> nums1 = Utils.getIntegers().stream();
        Stream<Integer> nums2 = List.of(1, 2, 9, 4, 7, 2, 0, -3, 11).stream();
        Stream<Integer> nums3 = Stream.concat(nums1, nums2);
        nums3.forEach(System.out::println);
    }
}
