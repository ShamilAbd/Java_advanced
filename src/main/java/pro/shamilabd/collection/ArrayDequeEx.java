package pro.shamilabd.collection;

import java.util.ArrayDeque;
import static pro.shamilabd.Utils.line;

public class ArrayDequeEx {
    public static void main(String[] args) {
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        nums.addFirst(4);
        nums.addLast(6);
        nums.offerFirst(3);
        nums.offerLast(1);
        System.out.println(nums);
        System.out.println(nums.getFirst());
        System.out.println(nums.getLast());
        System.out.println(nums.peekFirst());
        System.out.println(nums.peekLast());
        line();
        System.out.println(nums.removeFirst());
        System.out.println(nums.removeLast());
        System.out.println(nums);
        System.out.println(nums.pollFirst());
        System.out.println(nums.pollLast());
        System.out.println(nums);
        line();
    }
}
