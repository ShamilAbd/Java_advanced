package pro.shamilabd.collection;

import java.util.LinkedHashMap;
import static pro.shamilabd.Utils.line;

public class LinkedHashMapEx {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> nums = new LinkedHashMap<>();
        nums.put(3, 9);
        nums.put(1, 1);
        nums.put(4, 16);
        nums.put(2, 4);
        System.out.println(nums);
        line();

        nums.put(9, 81);
        nums.put(7, 49);
        nums.put(8, 64);
        System.out.println(nums);
        line();
        System.out.println(nums.get(2));
        System.out.println(nums.get(1));
        // nothing change
        System.out.println(nums);
        line();
        line();

        LinkedHashMap<Integer, Integer> numsWithOrder = new LinkedHashMap<>(9, 0.75f, true);
        numsWithOrder.put(3, 9);
        numsWithOrder.put(1, 1);
        numsWithOrder.put(4, 16);
        numsWithOrder.put(2, 4);
        System.out.println(numsWithOrder);
        line();

        numsWithOrder.put(9, 81);
        numsWithOrder.put(7, 49);
        numsWithOrder.put(8, 64);
        System.out.println(numsWithOrder);
        line();
        System.out.println(numsWithOrder.get(2));
        System.out.println(numsWithOrder.get(1));
        // order changed
        System.out.println(numsWithOrder);
        line();

    }
}
