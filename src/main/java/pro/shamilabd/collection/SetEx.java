package pro.shamilabd.collection;

import java.util.HashSet;
import java.util.Set;
import static pro.shamilabd.Utils.line;

public class SetEx {

    public static void main(String[] args) {
        simpleHashSet();
        hashSetMethod();
    }

    private static void hashSetMethod() {
        HashSet<Integer> nums1 = new HashSet<>();
        nums1.add(1);
        nums1.add(2);
        nums1.add(3);
        nums1.add(4);
        nums1.add(5);

        HashSet<Integer> nums2 = new HashSet<>();
        nums2.add(6);
        nums2.add(7);
        nums2.add(8);
        nums2.add(4);
        nums2.add(2);

        HashSet<Integer> nums3 = new HashSet<>();
        nums3.add(1);
        nums3.add(2);
        nums3.add(3);

        System.out.println(nums1.contains(4));
        System.out.println(nums1.contains(9));
        line();
        System.out.println(nums1.containsAll(nums2));
        System.out.println(nums1.containsAll(nums3));
        line();
//        System.out.println(nums1.removeAll(nums2)); // Удалить все, что вошло в этот список - 3 и 5
//        System.out.println(nums1);
//        line();
        System.out.println(nums1.retainAll(nums2)); // Удалить все, кроме этого набора - 2 и 4
        System.out.println(nums1);
        line();
        System.out.println(nums3);
        nums3.addAll(nums2); // Объединить множества
        System.out.println(nums3);
        line();
    }

    public static void simpleHashSet() {
        /*
        По сути это обертка над HashMap, потому важно переопределять equals and hashCode
        Работает почти как HashMap, но у него нет get()
         */
        Set<String> set = new HashSet<>(); // inside is HashMap
        set.add("Abdullin");
        set.add("Bagautdinov");
        set.add("Vasilev");
        set.add("Gatin");
        set.add("Danchov");
        set.add("Yamalow");
        set.add(null);
        System.out.println(set);
        line();
    }
}
