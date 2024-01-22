package pro.shamilabd.stream;

import pro.shamilabd.Utils;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.05.2023
 */
public class DistinctEx {
    public static void main(String[] args) {
        Utils.getIntegers().stream().sorted().distinct().forEach(System.out::println);
    }
}
