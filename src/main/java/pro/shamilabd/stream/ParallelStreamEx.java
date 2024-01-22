package pro.shamilabd.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 16.05.2023
 */
public class ParallelStreamEx {
    public static void main(String[] args) {
        // С parallelStream нужно быть внимательным, когда порядок выполнения операций важен

        List<Double> nums = new ArrayList<>();
        nums.add(10.0);
        nums.add(5.0);
        nums.add(1.0);
        nums.add(0.25);
        // и add еще миллион значений

        double sum = nums.parallelStream().reduce((a, e) -> a + e).get(); // ОК
        System.out.println(sum);

        sum = nums.stream().reduce((a, e) -> a / e).get(); // ОК - 8
        System.out.println(sum);
        sum = nums.parallelStream().reduce((a, e) -> a / e).get(); // Не ОК - 0.5
        System.out.println(sum);
    }
}
