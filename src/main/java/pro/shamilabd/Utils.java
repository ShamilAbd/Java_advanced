package pro.shamilabd;

import java.util.List;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 24.04.2023
 */
public class Utils {
    private Utils() {
    }

    public static int[] getInts() {
        int[] nums = {1, 8, 9, 5, 6, 4, 7, 2, 0, -1, 5, -6, 7, -3, 11};
        return nums;
    }

    public static List<Integer> getIntegers() {
        List<Integer> nums = List.of(1, 8, 9, 5, 1, 4, 7, 2, 0, -1, 5, -6, 1, -3, 11);
        return nums;
    }

    public static void line() {
        System.out.println("----------------------------------------");
    }

    public static void line(boolean addNewLineBefore) {
        if (addNewLineBefore) {
            System.out.println();
        }
        line();
    }
}
