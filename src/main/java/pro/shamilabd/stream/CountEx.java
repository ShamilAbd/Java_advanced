package pro.shamilabd.stream;

import pro.shamilabd.Utils;

import java.util.List;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.05.2023
 */
public class CountEx {
    public static void main(String[] args) {
        List<Integer> nums = Utils.getIntegers();
        System.out.println(nums.stream().count());
        System.out.println(nums.stream().distinct().count());
    }
}
